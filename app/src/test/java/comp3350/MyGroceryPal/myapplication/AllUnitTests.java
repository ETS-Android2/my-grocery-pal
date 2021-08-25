package comp3350.MyGroceryPal.myapplication;

import comp3350.MyGroceryPal.myapplication.Items.ItemsTest;
import comp3350.MyGroceryPal.myapplication.Items.StoreTest;
import comp3350.MyGroceryPal.myapplication.Logic.CartTest;
import comp3350.MyGroceryPal.myapplication.Logic.ExceptionsIT;
import comp3350.MyGroceryPal.myapplication.Logic.FilterTest;
import comp3350.MyGroceryPal.myapplication.Logic.OptionBundleTest;
import comp3350.MyGroceryPal.myapplication.Logic.SearchAlgoTest;
import comp3350.MyGroceryPal.myapplication.Logic.ShopOptionTest;
import comp3350.MyGroceryPal.myapplication.Logic.SortTest;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.DatabaseTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OptionBundleTest.class,
        ShopOptionTest.class,
        SortTest.class,
        StoreTest.class,
        ItemsTest.class,
        FilterTest.class,
        ExceptionsIT.class,
        CartTest.class,
        DatabaseTest.class,
        SearchAlgoTest.class
})

public class AllUnitTests
{

}