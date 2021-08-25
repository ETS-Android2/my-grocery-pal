package comp3350.MyGroceryPal.myapplication.Items;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {
    Store store;
    StoreItems item1;
    StoreItems item2;
    @Before
    public void setup() {
        ArrayList <StoreItems> items= new ArrayList<StoreItems>();
        item1=new StoreItems("Milk",6,"Dairy",5.99);
        item2=new StoreItems("Bread",10,"Grain",3.99);
        items.add(item1);
        items.add(item2);

        store=new Store("TestStore",100,5,1029,false,items);
    }
    @Test
    public void getItems() {
        assertEquals(store.getItems().get(0),item1);
        assertEquals(store.getItems().get(1),item2);
        assertEquals(2,store.getItems().size());
    }

    @Test
    public void getName() {
        //this also tests for null
        assertEquals("TestStore",store.getName());

    }

    @Test
    public void getReview() {
        assertEquals(5,store.getReview(),0);
    }

    @Test
    public void getDistance() {
        assertEquals(100,store.getDistance(),0);
    }

    @Test
    public void getLocal() {
        assertEquals(false,store.getLocal());
    }

    @Test
    public void updateReviewRating(){
        store.updateReviewRating(1);
        assert (store.getReview()==4.9961166f);

    }
}