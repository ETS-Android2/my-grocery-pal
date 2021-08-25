package comp3350.MyGroceryPal.myapplication.Items.Storeitems.StoreItems;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreItemsTest {
    StoreItems storeItems;
    @Before
    public void setUp() throws Exception {
        storeItems = new StoreItems("Yogurt", 9,"Dairy",9.99);
    }





    @Test
    public void getPrice() {
        assertEquals(9.99,storeItems.getPrice(),0);
    }

    @Test
    public void setPrice() {
        storeItems.setPrice(14.99);
        assertEquals(14.99,storeItems.getPrice(),0);
    }
}