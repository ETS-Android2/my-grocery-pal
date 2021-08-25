package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import java.util.List;

public class NewAccessGroceryItems {
    private NewGroceryItemPersistence newGroceryItemPersistence;



    public NewAccessGroceryItems(){
       this(Services.getGroceryListItemPersistence());


    }
    public NewAccessGroceryItems(final NewGroceryItemPersistence newGroceryItemPersistence){

        this.newGroceryItemPersistence=newGroceryItemPersistence;
    }

    public List<GroceryListItems> getGroceryListItemsByType(String type){
        return newGroceryItemPersistence.getGroceryItemListWithType(type);
    }

    public List<String> getTypeList(){
        return newGroceryItemPersistence.groceryItemTypeList();
    }

    public List<GroceryListItems> getGroceryItemListByName(String name){ return newGroceryItemPersistence.groceryItemListByName(name);}


}

