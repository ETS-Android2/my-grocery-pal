package comp3350.MyGroceryPal.myapplication.Logic;


import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeList;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.PersistenceException;
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


public class ExceptionsIT {
    private AccessRecipeList accessRecipeList;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final RecipeListPersistence persistence = new RecipesHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessRecipeList = new AccessRecipeList(persistence);
    }

    @Test(expected=PersistenceException.class)
    public void testInsertNonUniqueRecipe() {
        List<GroceryListItems> ingredients = new ArrayList<GroceryListItems>();
        List<String> steps = new ArrayList<String>();
        ingredients.add(new GroceryListItems("Oranges", 2,"Fruit And Vegetables"));
        steps.add("1. Put oranges to blender");
        steps.add("2. Add ice and serve!");
        final Recipe r = new Recipe("Watermelon Ice Cream", "Refreshing", ingredients, steps);
        accessRecipeList.insertRecipe(r);
    }

    @Test(expected=PersistenceException.class)
    public void testInsertNonexistentGroceryName() {
        List<GroceryListItems> ingredients = new ArrayList<GroceryListItems>();
        List<String> steps = new ArrayList<String>();
        ingredients.add(new GroceryListItems("wjenfklaf", 2,"Fruit And Vegetables"));
        steps.add("1. Put oranges to blender");
        steps.add("2. Add ice and serve!");
        final Recipe r = new Recipe("Orange Juice", "Refreshing", ingredients, steps);
        accessRecipeList.insertRecipe(r);
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}