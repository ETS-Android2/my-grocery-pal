package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.GroceryListItemStub;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewAccessGroceryItemsTest {

    private NewAccessGroceryItems accessGroceryItems;

    @Before
    public void setUp() throws Exception {
        this.accessGroceryItems = new NewAccessGroceryItems(new GroceryListItemStub());
        Database database= new Database();
    }



    @Test
    public void getGroceryListItemsByType() {
        if(accessGroceryItems==null){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        assertNotNull(accessGroceryItems.getGroceryListItemsByType("Dairy"));
        assertNull(accessGroceryItems.getGroceryListItemsByType("NOPE"));
        assert(accessGroceryItems.getGroceryListItemsByType("Alcohol").get(0).getName().equals("Apple Cider"));

    }

    @Test
    public void getTypeList() {
        assertNotNull(accessGroceryItems.getTypeList());
        assert (accessGroceryItems.getTypeList().contains("Dairy"));
        assertFalse (accessGroceryItems.getTypeList().contains("dairy"));
    }

    @Test
    public void getGroceryItemListByName() {
        assertNotNull(accessGroceryItems.getGroceryItemListByName("a"));
        assert(accessGroceryItems.getGroceryItemListByName("afhaifjiwa").size()==0);
        boolean con =false;

        for (int i=0;i<accessGroceryItems.getGroceryItemListByName("a").size();i++){
            if(accessGroceryItems.getGroceryItemListByName("a").get(i).getName().equals("Apple")){
                con=true;
            }
        }
        assert(con);
    }
}