package comp3350.MyGroceryPal.myapplication.Items;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Items;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsTest {
    Items items;
    @Before
    public void setUp() throws Exception {
        items=new GroceryListItems("Candy",9,"Sweets");
    }



    @Test
    public void getName() {
        assertEquals("Candy",items.getName());
    }

    @Test
    public void getAmount() {
        assertEquals(9,items.getAmount());
    }

    @Test
    public void setAmount() {
        items.setAmount(1);
        assertEquals(1,items.getAmount());
    }

    @Test
    public void getType() {
        assertEquals("Sweets",items.getType());
    }
}