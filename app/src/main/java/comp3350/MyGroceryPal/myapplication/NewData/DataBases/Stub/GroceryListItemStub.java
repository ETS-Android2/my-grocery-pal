package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import java.util.List;

public class GroceryListItemStub implements NewGroceryItemPersistence {
    //this is an arraylist of arraylist of grocery list items. Each arraylist in this arrayList if responsible
    //for holding all items with the same type
   // private ArrayList<ArrayList<GroceryListItems>> list;

    public GroceryListItemStub(){


    }

    @Override
    public List<GroceryListItems> getGroceryItemListWithType(String type) {
        return Database.returnGroceryItemListByType(type);
    }

    @Override
    public List<String> groceryItemTypeList() {
        return Database.returnGroceryListTypeList();
    }

    @Override
    public List<GroceryListItems> groceryItemListByName(String name) {
        return Database.returnGroceryListItemsByName(name);
    }


}

