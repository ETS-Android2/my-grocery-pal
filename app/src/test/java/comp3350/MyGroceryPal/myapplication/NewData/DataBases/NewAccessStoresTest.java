package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.StoreListPersistenceStub;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NewAccessStoresTest {
    NewAccessStores newAccessStores;
    @Before
    public void setUp() throws Exception {
        Database database= new Database();
        newAccessStores = new NewAccessStores(new StoreListPersistenceStub());

    }

    @Test
    public void getStores() {
        assertNotNull(newAccessStores.getStores());
        assert(newAccessStores.getStores().size()==6);
        List<Store> storeList=newAccessStores.getStores();
        boolean con =false;
        for (int i=0;i<storeList.size();i++){
            if(storeList.get(i).getName().equals("Walmart")){
                con=true;
            }
        }
        assert(con);
    }
}