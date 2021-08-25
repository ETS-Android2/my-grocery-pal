package comp3350.MyGroceryPal.myapplication.Logic;

import android.content.Context;
import android.content.res.AssetManager;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Main;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStores;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.StoreHSQLDB;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;
import comp3350.MyGroceryPal.myapplication.Utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SearchAlgoTest {
    private NewAccessStores accessStores;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final NewStorePersistence persistence = new StoreHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessStores = new NewAccessStores(persistence);
    }

    @Test
    public void testSearchNonExistentItem() {
        ArrayList<GroceryListItems> groceryList = new ArrayList<GroceryListItems>();
        groceryList.add(new GroceryListItems("Pasta", 5, "Grains"));

        searchAlgorithm.mainAlgo(groceryList);
        assertTrue(searchAlgorithm.getGrand().size() == 0);
    }

    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
