package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;

import java.util.ArrayList;
import java.util.List;

public class StoreListPersistenceStub implements NewStorePersistence {
    private ArrayList<Store> storeList;

    public StoreListPersistenceStub() {
        storeList = Database.getStoreList();
    }

    private static ArrayList<StoreItems> duplicateStoreItemsList(ArrayList<StoreItems> original){
        ArrayList<StoreItems> newCopy = new ArrayList<StoreItems>();
        for (int i=0;i<original.size();i++){
            StoreItems temp = original.get(i);
            newCopy.add(new StoreItems(temp.getName(),temp.getAmount(),temp.getType(),temp.getPrice()));
        }
        return newCopy;
    }

    @Override
    public List<Store> getStoreList() {
        return storeList;
    }

    @Override
    public void updateReview(Store store, float score) {
        Database.updateReview(store,score);
    }

    @Override
    public void incrementAmount(Store store) {
        Database.incrementAmount(store);
    }

    @Override
    public Store getStore(String name) {
        return Database.getStore(name);
    }


}
