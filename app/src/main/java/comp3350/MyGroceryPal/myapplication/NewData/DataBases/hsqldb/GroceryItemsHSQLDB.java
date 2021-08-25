package comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroceryItemsHSQLDB implements NewGroceryItemPersistence {
    private final String dbPath;

    public GroceryItemsHSQLDB(final String dbPath){ this.dbPath=dbPath; }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private GroceryListItems fromResultSet(final ResultSet rs)throws SQLException{
        final String name = rs.getString("name");

        final String type = rs.getString("type");
        return new GroceryListItems(name,1,type);
    }

    //get all the groceryListItems from the same type
    @Override
    public List<GroceryListItems> getGroceryItemListWithType(String type) {
        List <GroceryListItems> groceryListItemsListByType = new ArrayList<GroceryListItems>();
        try (final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM grocerylistitems WHERE type=?");
            st.setString(1,type);
            final ResultSet rs = st.executeQuery();

            while (rs.next()){
                final GroceryListItems groceryListItem= fromResultSet(rs);
                groceryListItemsListByType.add(groceryListItem);
            }
            rs.close();
            st.close();
            return groceryListItemsListByType;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    //gets all the types a grocery List Item can be
    @Override
    public List<String> groceryItemTypeList() {
        List <String> typeList= new ArrayList<String>();
        try (final Connection c = connection()){
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT DISTINCT type FROM grocerylistitems");

            while (rs.next()){
               // final GroceryListItems groceryListItem= fromResultSet(rs);


                typeList.add(rs.getString("type"));
            }

            rs.close();
            st.close();
            return typeList;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }


    }

    //get all grocery list items where it's name has the parameter as a substring
    @Override
    public List<GroceryListItems> groceryItemListByName(String name) {
        List <GroceryListItems> groceryItemListByName= new ArrayList<GroceryListItems>();
        try (final Connection c = connection()){

            final PreparedStatement st = c.prepareStatement("SELECT * FROM grocerylistitems WHERE LOWER(name) LIKE '%"+ name.toLowerCase() +"%'");


            final ResultSet rs = st.executeQuery();

            while (rs.next()){
                final GroceryListItems groceryListItem= fromResultSet(rs);
                System.out.println(groceryListItem.getName());
                groceryItemListByName.add(groceryListItem);


            }

            rs.close();
            st.close();
            return groceryItemListByName;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }


}
