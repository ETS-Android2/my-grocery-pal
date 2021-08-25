package comp3350.MyGroceryPal.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterAccount {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {

        AccountPersistence accountPersistence = Services.getAccountPersistence();
    }


    /*
        1: Click Profile Button
        2: Click Log In
        3: Click Register
        4-6: Enter every input value as gerald (since gerald username exist it should fail)
        7: you should still be in the register page since it failed and check if username input is still gerald
     */
    @Test
    public void registerAccountDeniedBecauseAccountExist(){
        //click profile button
        Espresso.onView(ViewMatchers.withId(R.id.account_button)).perform(ViewActions.click());

        //click log in button
        Espresso.onView(ViewMatchers.withId(R.id.loginBtn)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.registerLink)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.registerUsername)).perform(ViewActions.replaceText("gerald"));
        Espresso.onView(ViewMatchers.withId(R.id.registerPassword)).perform(ViewActions.replaceText("gerald"));
        Espresso.onView(ViewMatchers.withId(R.id.registerName)).perform(ViewActions.replaceText("gerald"));

        Espresso.onView(ViewMatchers.withId(R.id.registerButton)).perform(ViewActions.click());

        //click ok
        Espresso.onView(withId(android.R.id.button1)).perform(ViewActions.click());

        Espresso.onView(withId(R.id.registerUsername)).check(ViewAssertions.matches(withText("gerald")));
    }
}
