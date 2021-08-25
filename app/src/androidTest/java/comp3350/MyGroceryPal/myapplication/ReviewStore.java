package comp3350.MyGroceryPal.myapplication;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.R;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStores;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ReviewStore {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {
        NewGroceryItemPersistence groceryPersist = Services.getGroceryListItemPersistence();
        NewStorePersistence storePersist = Services.getStorePersistence();
    }

    /*
    1: Click Browse
    2: Click Grains
    3: Click Rice
    4: have an amount of 5
    5: Click Add
    6: Go to cart
    7: find stores
    8: Click first store option
    9: Click review
    */

    @Test
    public void reviewStore(){
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

        //click first store options
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));

        //press review
        Espresso.onView(withId(R.id.rView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,clickItemWithId(R.id.button)));


    }


    ViewAction clickItemWithId(int id) {
        ViewAction object = new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
        return object;

    }

}
