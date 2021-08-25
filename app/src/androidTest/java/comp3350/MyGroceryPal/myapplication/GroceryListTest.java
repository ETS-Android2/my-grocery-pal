package comp3350.MyGroceryPal.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
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
public class GroceryListTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {
        NewGroceryItemPersistence groceryPersist = Services.getGroceryListItemPersistence();
        NewStorePersistence storePersist = Services.getStorePersistence();
    }

    /*
    Acceptance test:
    1. start a fresh install
	2. click on "Browse" tab on bottom left corner
	3. Choose the type of the item you want to add
	4. Click on the item you want
	5. Enter the amount, then click "Add"
	6. Check that it was added correctly by clicking on the "Cart" tab on bottom center, the item added with a correct amount should be in the list.
     */
    @Test
    public void addItemToCart() {
        // click browse
        Espresso.onView(withId(R.id.fragmentBrowseV2)).perform(ViewActions.click());

        // click on a type
        Espresso.onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));

        // click on an item
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        // Enter amount
        Espresso.onView(withId(0)).perform(ViewActions.typeText("5"));
        // Click add
        Espresso.onView(withId(android.R.id.button1)).perform(ViewActions.click());

        // check that it was added correctly
        Espresso.onView(withId(R.id.cartFragment)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.item_name)).check(ViewAssertions.matches(withText("Butter")));
        Espresso.onView(withId(R.id.itemAmount)).check(ViewAssertions.matches(withText("5")));

        cart.deleteGroceryItem(0);
    }

}
