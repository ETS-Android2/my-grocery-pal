package comp3350.MyGroceryPal.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FilterResultsTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {
        NewGroceryItemPersistence groceryPersist = Services.getGroceryListItemPersistence();
        NewStorePersistence storePersist = Services.getStorePersistence();
    }

    /*
    1: Start a fresh install
    2:Click Browse
    3: Click Grains
    4: Click Rice
    5: Get an amount of 5
    6: click Add
    7: Go To Cart
    8: Click FindStores
    9: Click Local
    10: Check If correct values
        - Local - Price -$119.25 - Distance 20.62km Review 2.53
    11: Go back
    12: Click Review
    13: Check if correct values
    - Not Local - Price -$179.25 - Distance 30.64km Review 3.83
     */

    @Test
    public void filterResults(){
        // click browse
        Espresso.onView(withId(R.id.fragmentBrowseV2)).perform(ViewActions.click());

        // click Grains
        Espresso.onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, ViewActions.click()));

        //Click Rice
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, ViewActions.click()));

        //have an amount of 5
        Espresso.onView(withId(0)).perform(ViewActions.typeText("5"));

        //Click Add
        Espresso.onView(withId(android.R.id.button1)).perform(ViewActions.click());


        // Go to Cart
        Espresso.onView(withId(R.id.cartFragment)).perform(ViewActions.click());

        // Click find stores
        Espresso.onView(withId(R.id.findStores)).perform(ViewActions.click());

        //Click Local
        Espresso.onView(withId(R.id.local)).perform(ViewActions.click());

        //Check if correct values
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.onView(withId(R.id.Local)).check(ViewAssertions.matches(withText("Local")));
        Espresso.onView(withId(R.id.Price)).check(ViewAssertions.matches(withText("Price: $119.95")));
        Espresso.onView(withId(R.id.Distance)).check(ViewAssertions.matches(withText("Distance: 20.6km")));
        Espresso.onView(withId(R.id.Review)).check(ViewAssertions.matches(withText("Review: 2.5")));

        //go back
        Espresso.onView(withId(R.id.GoBack)).perform(ViewActions.click());


        //click review
        Espresso.onView(withId(R.id.review)).perform(ViewActions.click());

        //check if correct values
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.onView(withId(R.id.Local)).check(ViewAssertions.matches(withText("Not Local")));
        Espresso.onView(withId(R.id.Price)).check(ViewAssertions.matches(withText("Price: $179.95")));
        Espresso.onView(withId(R.id.Distance)).check(ViewAssertions.matches(withText("Distance: 30.6km")));
        Espresso.onView(withId(R.id.Review)).check(ViewAssertions.matches(withText("Review: 3.8")));
    }
}
