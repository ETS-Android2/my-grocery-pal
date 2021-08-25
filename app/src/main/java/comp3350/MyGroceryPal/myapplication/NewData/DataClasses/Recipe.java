package comp3350.MyGroceryPal.myapplication.NewData.DataClasses;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;

import java.util.List;

public class Recipe {
    //stores all the items in the Recipe's ingredient
    private String name;
    private String description;
    private List<GroceryListItems> ingredients;
    private List<String> steps;

    public Recipe(String recipeName, String recipeDesc, List<GroceryListItems> ingredients, List<String> steps) {
        name = recipeName;
        description = recipeDesc;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    //----getters----
    public String getName() {
        return name;
    }

    public String getDesc() {return description; }

    public List<GroceryListItems> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }
    //-------------

    // add all the ingredients in the Recipe to the grocery cart
    public void addIngredientsToCart() {
        for(int i = 0; i < ingredients.size();i++) {
            cart.addGroceryItem(ingredients.get(i));
        }
    }
}
