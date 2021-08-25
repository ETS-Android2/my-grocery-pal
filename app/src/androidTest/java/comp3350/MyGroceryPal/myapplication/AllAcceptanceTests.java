package comp3350.MyGroceryPal.myapplication;
import androidx.test.filters.LargeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@LargeTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RecipeTest.class,
        FindStoresTest.class,
        LogInTest.class,
        GroceryListTest.class,
        FilterResultsTest.class,
        RegisterAccount.class,
        ReviewStore.class

})

public class AllAcceptanceTests {
}
