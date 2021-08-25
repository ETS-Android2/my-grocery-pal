package comp3350.MyGroceryPal.myapplication.Logic;



import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.ShopOption;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class FilterTest {
    ArrayList<ShopOption> shops;
    ArrayList<ShopOption> shops1;
    ArrayList<OptionBundle> groc;
    ArrayList<OptionBundle> t;
    @Before
    public void setup() {
        shops = new ArrayList<ShopOption>();
        shops1 = new ArrayList<ShopOption>();
        groc = new ArrayList<OptionBundle>();
        groc.add(new OptionBundle(shops, 25, 12, 90, false));
        groc.add(new OptionBundle(shops1,30,6,60,true));
        groc.add(new OptionBundle(shops1,35,7,50,false));

    }

    @Test
    public void filterTestPrice(){
        //Filter test price
        t= searchAlgorithm.listFilteredByPrice(groc,80);
        assertFalse(t.get(t.size()-1).getTotalPrice()>80);
    }

    @Test
    public void filterTestDist(){
        //Filter test distance
        t=searchAlgorithm.listFilteredByMaxDist(groc,30);
        assertFalse(t.get(t.size()-1).getMaxDistance()>30);

    }

    @Test
    public void filterTestLocal(){
        //Filter test local
        t=searchAlgorithm.listFilteredByLocal(groc);
        for(int i=0;i<t.size();i++){
            assertTrue(t.get(i).allLocal());
        }
    }

}