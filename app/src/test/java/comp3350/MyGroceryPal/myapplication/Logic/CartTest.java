package comp3350.MyGroceryPal.myapplication.Logic;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CartTest {
    /*private NewAccessGroceryItems accessGroceryItems;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final NewGroceryItemPersistence persistence = new GroceryItemsHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessGroceryItems = new NewAccessGroceryItems(persistence);
    }*/

    @Test
    public void testAddGroceryItem() {
        GroceryListItems addItem = new GroceryListItems("Bread", 3, "Grains");
        cart.addGroceryItem(addItem);
        assertNotNull(cart.searchItem("Bread"));
    }

    @Test
    public void testSearchItem() {
        GroceryListItems addItem = new GroceryListItems("Bread", 3, "Grains");
        cart.addGroceryItem(addItem);
        assertNotNull(cart.searchItem("Bread"));
        assertEquals(6,cart.searchItem("Bread").getAmount());
    }

    @Test
    public void testGetGroceryList() {
        cart.addGroceryItem(new GroceryListItems("Grapes", 3, "Fruits and Vegetables"));
        cart.addGroceryItem(new GroceryListItems("Watermelon", 4, "Fruits and Vegetables"));
        cart.addGroceryItem(new GroceryListItems("Milk", 2, "Dairy"));
        cart.addGroceryItem(new GroceryListItems("Bread", 4, "Grains"));
        cart.addGroceryItem(new GroceryListItems("Apple", 5, "Fruits and Vegetables"));
        assertEquals(5, cart.getGroceryList().size());
        assertTrue(cart.getGroceryList().get(0).getName().equals("Bread"));
    }

    @Test
    public void testDeleteGroceryItem() {
        for (int i = 0; i < cart.getGroceryList().size()-1; i++) {
            cart.deleteGroceryItem(i);
        }
    }

    @Test
    public void testChangeAmount() {
        cart.changeAmount(0, 10);
        assertEquals(1, cart.getGroceryList().size());
        assertEquals(10, cart.getGroceryList().get(0).getAmount());
    }

    @Test
    public void testSearchNonExistentItem() {
        GroceryListItems item = new GroceryListItems("Butter", 3, "");
        assertNull(cart.searchItem(item.getName()));
    }

    /*@After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }*/
}