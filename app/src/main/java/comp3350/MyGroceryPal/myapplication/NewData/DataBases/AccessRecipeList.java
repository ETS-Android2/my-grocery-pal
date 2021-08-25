package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;

import java.util.List;

public class AccessRecipeList {
    private RecipeListPersistence recipeListPersistence;
    private List<Recipe> recipeList;



    public AccessRecipeList(final RecipeListPersistence recipeListPersistence) {

        this.recipeListPersistence = recipeListPersistence;
    }
    public AccessRecipeList()
    {

        this(Services.getRecipeListPersistence());
        recipeList = null;
    }

    public List<Recipe> getRecipeList() {
        recipeList = recipeListPersistence.getRecipeList();
        return recipeList;
    }
    public Recipe insertRecipe(Recipe theRecipe) {
        return recipeListPersistence.insertRecipe(theRecipe);
    }

    public Recipe getRecipeByName(String name) {
        return recipeListPersistence.getRecipeByName(name);
    }

    public void deleteRecipe(Recipe theRecipe) {
        recipeListPersistence.deleteRecipe(theRecipe);
    }
}
