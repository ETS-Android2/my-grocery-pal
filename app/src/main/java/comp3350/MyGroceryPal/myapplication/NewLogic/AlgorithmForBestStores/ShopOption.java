package comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;

/*
 * ShopOption
 * The class that combines a Store and its StoreItems that matched with
 * a grocery item in the grocery list.
 * used for the search algorithm
 */

public class ShopOption  {
    public Store storeOption;
    public StoreItems available;

    public ShopOption(Store useIt,StoreItems item){
        this.storeOption=useIt;
        this.available=item;
    }

    public Store getStore() {
        return storeOption;
    }

    public StoreItems getItems() {
        return available;
    }
}
