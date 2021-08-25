package comp3350.MyGroceryPal.myapplication.Logic;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.ShopOption;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ShopOptionTest {
    ShopOption option;
    @Before
    public void setup() {
        ArrayList<StoreItems> items = new ArrayList<StoreItems>();
        items.add(new StoreItems("apple", 8, "Fruits", 10));
        option = new ShopOption(new Store("Walmart", 10, 4, 5,false, items),
                items.get(0));
    }

    @Test
    public void testCreateShopOption() {
        assertNotNull(option);
    }

    @Test
    public void testGetStore() {
        assertTrue(option.getStore().getName().equals("Walmart"));
    }

    @Test
    public void testGetItems() {
        assertTrue(option.getItems().getName().equals("apple"));
        assertEquals(10, (int) option.getItems().getPrice());
        assertEquals(8, (int) option.getItems().getAmount());
    }
}
