package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;

import java.util.List;


public interface RecipeListPersistence {
    List<Recipe> getRecipeList();

    Recipe insertRecipe(Recipe theRecipe);

    void deleteRecipe(Recipe theRecipe);

    Recipe getRecipeByName(String name);
}
