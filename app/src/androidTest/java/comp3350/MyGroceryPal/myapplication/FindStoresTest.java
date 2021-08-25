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
public class FindStoresTest {
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
	6. Click "Find Stores"
	7. Check whether the correct store is showing or not
     */
    @Test
    public void findStores() {
        // click browse
        Espresso.onView(withId(R.id.fragmentBrowseV2)).perform(ViewActions.click());

        // click on a type
        Espresso.onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, ViewActions.click()));

        // click on Oranges
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, ViewActions.click()));
        // Enter amount
        Espresso.onView(withId(0)).perform(ViewActions.typeText("80"));
        // Click add
        Espresso.onView(withId(android.R.id.button1)).perform(ViewActions.click());

        // Go to Cart
        Espresso.onView(withId(R.id.cartFragment)).perform(ViewActions.click());
        // Click find stores
        Espresso.onView(withId(R.id.findStores)).perform(ViewActions.click());

        //The only store that has 80 oranges will only be SuperStore at 123 Chespin St., which is not local
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.onView(withId(R.id.Local)).check(ViewAssertions.matches(withText("Not Local")));

        cart.deleteGroceryItem(0);
    }

}
