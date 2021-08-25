package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeList;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.RecipesHSQLDB;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;
import comp3350.MyGroceryPal.myapplication.Utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessRecipeListIT {
    private AccessRecipeList accessRecipeList;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final RecipeListPersistence persistence = new RecipesHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessRecipeList = new AccessRecipeList(persistence);
    }

    @Test
    public void testGetRecipeList() {
        final List<Recipe> recipeList;

        recipeList = accessRecipeList.getRecipeList();
        assertNotNull("recipe list should not be null", recipeList);
        assertEquals(4, recipeList.size());
    }

    @Test
    public void testGetRecipeByName() {
        final Recipe recipe = accessRecipeList.getRecipeByName("Watermelon Ice Cream");

        assertNotNull("recipe should not be null", recipe);
        assertTrue("Watermelon Ice Cream".equals(recipe.getName()));
    }

    @Test
    public void testDeleteRecipe() {
        List<Recipe> recipeList = accessRecipeList.getRecipeList();
        final Recipe delRecipe = accessRecipeList.getRecipeByName("Watermelon Ice Cream");
        accessRecipeList.deleteRecipe(delRecipe);
        assertEquals(4, recipeList.size());
        accessRecipeList.deleteRecipe(delRecipe);
        recipeList = accessRecipeList.getRecipeList();
        assertEquals(3, recipeList.size());
    }

    @Test
    public void testInsertRecipe() {
        List<GroceryListItems> ingredients = new ArrayList<GroceryListItems>();
        List<String> steps = new ArrayList<String>();
        ingredients.add(new GroceryListItems("Oranges", 2,"Fruit And Vegetables"));
        steps.add("1. Put oranges to blender");
        steps.add("2. Add ice and serve!");
        final Recipe r = new Recipe("Orange Juice", "Refreshing", ingredients, steps);
        accessRecipeList.insertRecipe(r);
        assertNotNull(accessRecipeList.getRecipeByName("Orange Juice"));
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
