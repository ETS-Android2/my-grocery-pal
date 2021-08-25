package comp3350.MyGroceryPal.myapplication.NewLogic;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import java.util.ArrayList;

public class cart {
    //stores all the items in the users cart/grocery list
    private static ArrayList<GroceryListItems> groceryList= new ArrayList<GroceryListItems>();

    //this adds the item the user selected from the browse screen to our cart
    public static boolean addGroceryItem(GroceryListItems groceryListItems){
        GroceryListItems exists = searchItem(groceryListItems.getName());
        //if item does not exist add it
        if (exists==null) {
            groceryList.add(groceryListItems);
            //else if it does exist add the new amount to the current one
        } else {
            //make sure the amount does not exceed 100
            if(exists.getAmount()+groceryListItems.getAmount()<=100)
                exists.setAmount(exists.getAmount()+groceryListItems.getAmount());
            else
                return false;
        }
        return true;
    }

    //searches the grocery list for a specific item
    public static GroceryListItems searchItem(String itemName){
        for (int i=0;i<groceryList.size();i++) {
            if (itemName.equals(groceryList.get(i).getName())){
                return groceryList.get(i);
            }
        }
        return null;
    }

    public static ArrayList<GroceryListItems> getGroceryList(){
        return groceryList;
    }

    public static void deleteGroceryItem(int pos){
        groceryList.remove(pos);
    }

    public static void changeAmount(int index, int amount){
        groceryList.get(index).setAmount(amount);
    }
}

