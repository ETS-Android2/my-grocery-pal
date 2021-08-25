package comp3350.MyGroceryPal.myapplication.Logic;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.ShopOption;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OptionBundleTest {
    OptionBundle optionBundle;
    @Before
    public void setup() {
        ArrayList<ShopOption> shops = new ArrayList<ShopOption>();
        ArrayList<StoreItems> items = new ArrayList<StoreItems>();
        items.add(new StoreItems("apple", 1, "Fruits", 10));
        items.add(new StoreItems("banana", 2, "Fruits", 10));
        items.add(new StoreItems("orange", 3, "Fruits", 10));
        ShopOption option = new ShopOption(new Store("Walmart", 10, 4, 5,true, items),
                items.get(0));
        shops.add(option);
        option = new ShopOption(new Store("Loca", 15, 3, 5,true, items),
                items.get(1));
        shops.add(option);
        option = new ShopOption(new Store("Safeway", 25, 5, 5,true, items),
                items.get(2));
        shops.add(option);
        optionBundle = new OptionBundle(shops, 25, 12, 30, true);
    }

    @Test
    public void testCreateOptionBundle() {
        assertNotNull(optionBundle);
        OptionBundle emptyBundle = new OptionBundle();
        assertNotNull(emptyBundle);
    }

    @Test
    public void testGetAverageReview() {
        assertEquals(4, optionBundle.getAverageReview(), 0);
    }

    @Test
    public void testGetMaxDistance() {
        assertEquals(25, optionBundle.getMaxDistance(), 0);
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(30, optionBundle.getTotalPrice(), 0);
    }

    @Test
    public void testTrueAllLocal() {
        assertTrue(optionBundle.allLocal());
    }

    @Test
    public void testGetNumDistinctStores() {
        assertEquals(3, optionBundle.getNumDistinctStores());
    }

    @Test
    public void testGetShopOptions() {
        ArrayList<ShopOption> shops = optionBundle.getShopOptions();
        assertEquals(3, shops.size(), 0);
        assertTrue(shops.get(0).getStore().getName().equals("Walmart"));
    }

    @Test
    public void testAddShopOption() {
        ArrayList<StoreItems> items = new ArrayList<StoreItems>();
        items.add(new StoreItems("apple", 1, "Fruits", 10));
        items.add(new StoreItems("banana", 2, "Fruits", 10));
        items.add(new StoreItems("orange", 3, "Fruits", 10));
        items.add(new StoreItems("cherry", 4, "Fruits", 10));
        ShopOption option = new ShopOption(new Store("Cosco", 30, 4, 5,false, items),
                items.get(3));
        optionBundle.addShopOption(option, 2);

        assertEquals(50, optionBundle.getTotalPrice(), 0);
        assertEquals(30, optionBundle.getMaxDistance(), 0);
        assertTrue(!optionBundle.allLocal());
        assertEquals(4, optionBundle.getShopOptions().size());
        assertEquals(4, optionBundle.getAverageReview(), 0);
    }

    @Test
    public void testClone() {
        OptionBundle cloneOptions = optionBundle.clone();
        assertTrue(cloneOptions.getShopOptions().get(0).getStore().getName().equals("Walmart"));
    }
}
