package comp3350.MyGroceryPal.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
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
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LogInTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupDatabase() {

        AccountPersistence accountPersistence = Services.getAccountPersistence();
    }

    /*
    Acceptance test:
    1. start a fresh install
	2. Click profile button
	3. Click log In Button
	4. Click Username text
	5. Erase any existing text in username text
	6. Enter Gerald
	7. Click Password text
	8. Erase any existing Password text
	9. Enter 12345678
	10. Click Log In
	11. Click ok
	12. Click Logout (if they can logout that means they signed in before)
     */

    @Test
    public void LogInForUsernameGeraldPassword12345678(){
        //click profile button
        Espresso.onView(ViewMatchers.withId(R.id.account_button)).perform(ViewActions.click());

        //click log in button
        Espresso.onView(ViewMatchers.withId(R.id.loginBtn)).perform(ViewActions.click());

        //click username text,erase text then enter username Gerald
        Espresso.onView(ViewMatchers.withId(R.id.loginUsername)).perform(ViewActions.replaceText("gerald"));

        //click password, erase text and enter 12345678
        Espresso.onView(ViewMatchers.withId(R.id.loginPassword)).perform(ViewActions.replaceText("12345678"));

        //click log in button
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click());

        //click ok
        Espresso.onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //click log out
        Espresso.onView(ViewMatchers.withId(R.id.logoutBtn)).perform(ViewActions.click());
    }

}
