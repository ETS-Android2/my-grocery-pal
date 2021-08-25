package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import java.util.Collections;
import java.util.List;

public class NewAccessStores {
    private NewStorePersistence storePersistence;
    private List<Store> stores;

    public NewAccessStores()
    {
        this(Services.getStorePersistence());
        stores=null;
    }

    public NewAccessStores(final NewStorePersistence newStorePersistence){

        this.storePersistence = newStorePersistence;
    }

    public List<Store> getStores(){
        stores=storePersistence.getStoreList();
        if(stores==null){
            return null;
        }
        return Collections.unmodifiableList(stores);
    }

    public Store getStore(String name){
        return storePersistence.getStore(name);
    }

    public void updateReview(Store store,float score){
        storePersistence.updateReview(store,score);
    }

    public void incrementAmount(Store store){
        storePersistence.incrementAmount(store);
    }
}
