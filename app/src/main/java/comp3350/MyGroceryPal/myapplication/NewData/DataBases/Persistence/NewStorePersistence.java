package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import java.util.List;

public interface NewStorePersistence {
    List<Store> getStoreList();
    void updateReview(Store store,float score);
    void incrementAmount(Store store);
    Store getStore(String name);
}
