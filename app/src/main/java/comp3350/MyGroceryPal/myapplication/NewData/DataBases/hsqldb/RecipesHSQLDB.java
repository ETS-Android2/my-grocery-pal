package comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb;


import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RecipesHSQLDB implements RecipeListPersistence {
    private final String dbPath;

    public RecipesHSQLDB(final String dbPath){ this.dbPath=dbPath; }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Recipe fromResultSet(final ResultSet rsRecipe)throws SQLException{
        final String name = rsRecipe.getString("name");
        final String desc = rsRecipe.getString("desc");
        List<GroceryListItems> ingredients = addIngredients(name);
        List<String> steps = addSteps(name);
        return new Recipe(name, desc, ingredients, steps);
    }

    //adds steps to a recipe
    private List <String> addSteps(String name){
        List <String> steps = new ArrayList<String>();
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM recipesteps WHERE rname=?");
            st.setString(1, name);
            final ResultSet rs = st.executeQuery();
            while(rs.next()) {
                steps.add(rs.getString("step"));
            }
            rs.close();
            st.close();
            return steps;
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private List <GroceryListItems> addIngredients(String name) throws SQLException {
        List <GroceryListItems> ingredients  = new ArrayList<GroceryListItems>();
        ResultSet rsIngredients;
        String type = "";
        try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("SELECT * FROM recipeingredients WHERE rname = ?");
            st.setString(1, name);
            rsIngredients = st.executeQuery();
            while(rsIngredients.next()) {
                try (final Connection cGrocery = connection()) {
                    PreparedStatement stGrocery = cGrocery.prepareStatement("SELECT type FROM grocerylistitems WHERE name = ?");
                    stGrocery.setString(1, rsIngredients.getString("gname"));
                    final ResultSet rs = stGrocery.executeQuery();
                    if(rs.next())
                        type = rs.getString("type");
                    rs.close();
                    stGrocery.close();
                } catch (final SQLException e) {
                    throw new PersistenceException(e);
                }
                if(!type.equals(""))
                    ingredients.add(new GroceryListItems(rsIngredients.getString("gname"), rsIngredients.getInt("quantity"), type));
            }
            rsIngredients.close();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        return ingredients;
    }

    @Override
    public List<Recipe> getRecipeList() {
        final List<Recipe> recipeList = new ArrayList<Recipe>();

        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM recipes");
            while (rs.next()){
                final Recipe recipe= fromResultSet(rs);
                recipeList.add(recipe);
            }
            rs.close();
            st.close();
            return recipeList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Recipe insertRecipe(Recipe theRecipe) {
        try (final Connection c = connection()){
            final PreparedStatement st1 = c.prepareStatement("INSERT INTO recipes VALUES(?,?)");
            st1.setString(1,theRecipe.getName());
            st1.setString(2,theRecipe.getDesc());
            st1.executeUpdate();
            for(int i = 0; i < theRecipe.getIngredients().size(); i++) {
                final PreparedStatement st2 = c.prepareStatement("INSERT INTO recipeingredients VALUES(?,?,?)");
                st2.setString(1,theRecipe.getIngredients().get(i).getName());
                st2.setString(2,theRecipe.getName());
                st2.setInt(3,theRecipe.getIngredients().get(i).getAmount());
                st2.executeUpdate();
            }
            for(int i = 0; i < theRecipe.getSteps().size(); i++) {
                final PreparedStatement st3 = c.prepareStatement("INSERT INTO recipesteps VALUES(?,?,?)");
                st3.setInt(1, i + 1);
                st3.setString(2, theRecipe.getName());
                st3.setString(3, theRecipe.getSteps().get(i));
                st3.executeUpdate();
            }
            return  theRecipe;
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }



    @Override
    public void deleteRecipe(Recipe theRecipe) {
        try (final Connection c = connection()){
            final PreparedStatement st= c.prepareStatement("DELETE FROM recipes WHERE name = ?");
            st.setString(1,theRecipe.getName());
            st.executeUpdate();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Recipe getRecipeByName(String name) {
        try (final Connection c = connection()) {
            PreparedStatement st = c.prepareStatement("SELECT * FROM recipes WHERE name = ?");
            st.setString(1,name);
            final ResultSet rs = st.executeQuery();
            Recipe recipe = null;
            if(rs.next()) {
                recipe= fromResultSet(rs);
            }
            rs.close();
            st.close();
            return recipe;
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
}
