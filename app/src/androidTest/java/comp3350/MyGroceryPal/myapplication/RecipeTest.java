package comp3350.MyGroceryPal.myapplication;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.R;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecipeTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {
        NewGroceryItemPersistence groceryPersist = Services.getGroceryListItemPersistence();
        NewStorePersistence storePersist = Services.getStorePersistence();
        RecipeListPersistence recipePersist = Services.getRecipeListPersistence();
    }

    /*
    Acceptance test:
    1. start a fresh install
	2. click on "Recipe" tab on bottom right corner
	3. Choose the recipe that you want to try
	4. Click on "ADD TO CART!" button to add the ingredients to our grocery list
	5. Check that it was added correctly by clicking on the "Cart" tab on bottom center
     */
    @Test
    public void addRecipeIngredientsToCart() {
        // click Recipe
        onView(withId(R.id.recipeFragment)).perform(click());

        // click on a Recipe
        onView(withId(R.id.recipeRView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // Add the ingredients to Cart
        onView(withId(R.id.AddToCart)).perform(click());

        // check that it was added correctly
        onView(withId(R.id.cartFragment)).perform(click());
        onView(allOf(withId(R.id.item_name), withText("Chicken"))).check(matches(withText("Chicken")));
        onView(allOf(withId(R.id.item_name), withText("Butter"))).check(matches(withText("Butter")));
        onView(allOf(withId(R.id.item_name), withText("Yogurt"))).check(matches(withText("Yogurt")));

        for(int i = 0; i < 3; i++) {
            cart.deleteGroceryItem(0);
        }
    }

}
