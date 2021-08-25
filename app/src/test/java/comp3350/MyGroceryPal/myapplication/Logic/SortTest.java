package comp3350.MyGroceryPal.myapplication.Logic;

import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.ShopOption;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class SortTest {
    ArrayList<OptionBundle> x1 = new ArrayList<OptionBundle>();
    ArrayList<ShopOption> shops;
    ArrayList<ShopOption> shops1;
    OptionBundle a1;
    OptionBundle a2;
    OptionBundle a3;

    @Before
    public void setup() {
        shops = new ArrayList<ShopOption>();
        shops1 = new ArrayList<ShopOption>();
        shops.add(null);
        shops1.add(null);
        a1=new OptionBundle(shops, 25, 12, 90, false);
        a2=new OptionBundle(shops1,30,6,60,true);
        a3=new OptionBundle(shops1,35,7,50,false);
        x1.add(a1);
        x1.add(a2);
        x1.add(a3);
    }

    @Test
    public void sortTestDist() {
        searchAlgorithm.sortByDist(x1);
        assertEquals(a1, x1.get(0));
    }
    @Test
    public void sortTestPrice(){
        searchAlgorithm.sortByPrice(x1);
        assertEquals(a3,x1.get(0));
    }
    @Test
    public void sortTestReview(){
        searchAlgorithm.sortByReview(x1);
        assertEquals(a1,x1.get(0));
    }

}
