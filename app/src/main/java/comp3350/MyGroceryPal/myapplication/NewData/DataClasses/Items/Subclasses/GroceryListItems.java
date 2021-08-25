package comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Items;

//represents all the items the user can add to their cart
public class GroceryListItems extends Items {
    public GroceryListItems(String name,int amount,String type){
        super(name,amount,type);
    }
}
