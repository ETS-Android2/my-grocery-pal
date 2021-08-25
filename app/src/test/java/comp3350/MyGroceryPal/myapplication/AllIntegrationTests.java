package comp3350.MyGroceryPal.myapplication;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeListIT;
import comp3350.MyGroceryPal.myapplication.Logic.ExceptionsIT;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessAccountTest;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessGroceryItemsTest;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStoresTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessRecipeListIT.class,
        ExceptionsIT.class,
        NewAccessAccountTest.class,
        NewAccessGroceryItemsTest.class,
        NewAccessStoresTest.class
})

public class AllIntegrationTests {
}
