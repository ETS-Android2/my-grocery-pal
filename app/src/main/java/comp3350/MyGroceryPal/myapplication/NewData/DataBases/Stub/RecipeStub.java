package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub;

import java.util.List;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;

public class RecipeStub implements RecipeListPersistence {
    public RecipeStub(){

    }

    @Override
    public List<Recipe> getRecipeList() {
        return Database.getRecipes();
    }

    @Override
    public Recipe insertRecipe(Recipe theRecipe) {
        return Database.insertRecipes(theRecipe);
    }

    @Override
    public void deleteRecipe(Recipe theRecipe) {
        Database.removeRecipe(theRecipe);
    }

    @Override
    public Recipe getRecipeByName(String name) {
        return Database.getRecipeByName(name);
    }
}
