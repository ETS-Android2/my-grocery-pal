package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import java.util.List;

public interface NewGroceryItemPersistence {

    List<GroceryListItems> getGroceryItemListWithType(String type);
    List<String> groceryItemTypeList();
    List<GroceryListItems> groceryItemListByName(String name);
}
