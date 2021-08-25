package comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores;

import android.util.Log;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStores;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;

import java.util.ArrayList;
import java.util.List;

/*
* searchAlgorithm
* The class that does all the logic for finding a combination of stores to match the user needs
* and their grocery list.
* The list can either be filtered based on the user's input or filtered by default
 */

public class searchAlgorithm {
    private static final float DISTANCE_LIMIT = 250; // The grand list shouldn't include stores that are further than this
    private static ArrayList<OptionBundle> grand = new ArrayList<OptionBundle>(); // list of all possible combination of
    private static NewAccessStores newAccessStores;                                                                              // ShopOptions to fulfill the grocery list
    private static List<Store> storeList = new ArrayList<Store>(); // list of all available stores that we can search an item from

    // The main algorithm that's going to find all the combination of stores where we can buy the items from
    public static void mainAlgo(ArrayList<GroceryListItems> groceryList) {
        grand.clear(); //clear the grand list first
        newAccessStores= new NewAccessStores();
        storeList=  newAccessStores.getStores();
        searchRecursive(groceryList, 0, new OptionBundle());
        // the grand list would be updated after the recursive call

    }

    // Search helper that will add all the possible OptionBundles to the grand list after it reached the base case
    private static void searchRecursive(ArrayList<GroceryListItems> grocery, int index, OptionBundle temp) {
        // Base Case:
        if (index == grocery.size()) { // the index has been out of bound
            grand.add(temp);
            return;
        }

        // Recursive Case:
        GroceryListItems find = grocery.get(index);
        // Search among all the listed stores for an item in the grocery list
        for (int i = 0; i < storeList.size(); i++) {
            StoreItems returned = searchItemInStore(find, storeList.get(i));
            if (returned != null) { // If the item is available in one of the stores
                OptionBundle passON = temp.clone();
                ShopOption addMe = new ShopOption(storeList.get(i), returned);
                passON.addShopOption(addMe, find.getAmount()); // Add the ShopOption to the OptionBundle
                searchRecursive(grocery, index + 1, passON);
            }
        }
    }

    // Search by availability of an item in the store
    // Returns the StoreItems that the Store actually has
    public static StoreItems searchItemInStore(GroceryListItems item, Store which) {
        ArrayList <StoreItems> storeItem = which.getItems();
        StoreItems current;
        StoreItems theItemInStore = null;
        for (int i = 0; i < storeItem.size() && theItemInStore == null; i++) {
            current=storeItem.get(i);
            if (current.getName().equals(item.getName()) && which.getDistance() < DISTANCE_LIMIT) {
                if (current.getAmount() >= item.getAmount()) {
                    theItemInStore = current;
                }
            }
        }
        return theItemInStore;
    }

    // To get the static grand list
    public static ArrayList<OptionBundle> getGrand() {
        return grand;
    }



    // Returns a list of cheapest OptionBundle, closest OptionBundle, best reviewed OptionBundle, and local OptionBundle
    // This function should be used when the user doesn't use the filter option
    public static ArrayList<OptionBundle> defaultBestOptions(ArrayList<OptionBundle> options) {
        ArrayList<OptionBundle> cloneGrand = new ArrayList<OptionBundle>();
        for(int i = 0; i < options.size(); i++) {
            cloneGrand.add(options.get(i).clone());
        }
        ArrayList<OptionBundle> bestOptions = new ArrayList<OptionBundle>();

        // Get all the best options by leveraging the filter and sort functions
        ArrayList<OptionBundle> cheapestList = listFilteredByPrice(cloneGrand, Integer.MAX_VALUE);
        ArrayList<OptionBundle> closestList = listFilteredByMaxDist(cloneGrand, DISTANCE_LIMIT);
        ArrayList<OptionBundle> bestReviewList = listFilteredByMinRev(cloneGrand, 0);

        if(cheapestList.size()>0&&closestList.size()>0 && bestReviewList.size()>0) {
            bestOptions.add(cheapestList.get(0));
            bestOptions.add(closestList.get(0));
            bestOptions.add(bestReviewList.get(0));
        }
        ArrayList<OptionBundle> closestLocals = listFilteredByLocal(cloneGrand);
        if(closestLocals.size() > 0) {
            OptionBundle closestLocal = listFilteredByLocal(cloneGrand).get(0);
            bestOptions.add(closestLocal);
        }

        return bestOptions;
    }

    // Returns a sorted list of OptionBundles that are filtered by price, all the total price must be within the budget
    public static ArrayList<OptionBundle> listFilteredByPrice(ArrayList<OptionBundle> options, double budgetPrice) {
        ArrayList<OptionBundle> returnList = new ArrayList<OptionBundle>();

        // Only add the ones that have total price within the budet
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getTotalPrice() <= budgetPrice) {
                returnList.add(options.get(i));
            }
        }

        sortByPrice(returnList); // sort the list in ascending order
        return returnList;
    }

    // Returns a sorted list of OptionBundles that are filtered by maximum distance, all the distance must be at most max
    public static ArrayList<OptionBundle> listFilteredByMaxDist(ArrayList<OptionBundle> options, float max) {
        ArrayList<OptionBundle> returnList = new ArrayList<OptionBundle>();

        // Only add the ones that have average maximum distance less than max
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getMaxDistance() <= max) {
                returnList.add(options.get(i));
            }
        }

        sortByDist(returnList); // sort the list in ascending order
        return returnList;
    }

    // Returns a sorted list of OptionBundles that are filtered by minimum review, all the average review must be at least minRev
    public static ArrayList<OptionBundle> listFilteredByMinRev(ArrayList<OptionBundle> options, float minRev) {
        ArrayList<OptionBundle> returnList = new ArrayList<OptionBundle>();

        // Only add the ones that have average review more than the minRev
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getAverageReview() >= minRev) {
                returnList.add(options.get(i));
            }
        }

        sortByReview(returnList); // sort the list in descending order
        return returnList;
    }

    // Returns a sorted list of OptionBundles that are filtered by local, all the stores must be local stores
    public static ArrayList<OptionBundle> listFilteredByLocal(ArrayList<OptionBundle> options) {
        ArrayList<OptionBundle> returnList = new ArrayList<OptionBundle>();

        // Only add the ones that are all local stores
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).allLocal()) {
                returnList.add(options.get(i));
            }
        }

        sortByDist(returnList); // sort the list in ascending order, show from the closest local stores to the furthest
        return returnList;
    }

    // Sort based on price in ascending order
    public static void sortByPrice(ArrayList<OptionBundle> options){
        for(int i=0;i<options.size();i++){
            OptionBundle currMin=options.get(i);
            int k=i;
            for(int j=i;j<options.size();j++){
                OptionBundle swap=options.get(j);
                if(currMin.getTotalPrice()>swap.getTotalPrice()){
                    currMin=options.get(j);
                    k=j;
                }
            }
            options.set(k,options.get(i));
            options.set(i,currMin);
        }
    }

    // Sort based on distance in ascending order
    public static void sortByDist(ArrayList<OptionBundle> options){
        for(int i=0;i<options.size();i++){
            OptionBundle currMin=options.get(i);
            int k=i;
            for(int j=i;j<options.size();j++){
                OptionBundle swap=options.get(j);
                if(currMin.getMaxDistance()>swap.getMaxDistance()){
                    currMin=options.get(j);
                    k=j;
                }
            }
            options.set(k,options.get(i));
            options.set(i,currMin);
        }
    }

    // Sort based on review in descending order
    public static void sortByReview(ArrayList<OptionBundle> options){
        for(int i=0;i<options.size();i++){
            OptionBundle currMin=options.get(i);
            int k=i;
            for(int j=i;j<options.size();j++){
                OptionBundle swap=options.get(j);
                if(currMin.getAverageReview()<swap.getAverageReview()){
                    currMin=options.get(j);
                    k=j;
                }
            }
            options.set(k,options.get(i));
            options.set(i,currMin);
        }
    }

    //used for store statistics
    public static ArrayList<OptionBundle> getDesiredList(String key){
        //NOTE: we are not using java streams as we are ordering the list, not getting rid of options that do not meet a condition
        switch(key){
            case "none":
                return  searchAlgorithm.getGrand();

            case "price":
                return searchAlgorithm.listFilteredByPrice(searchAlgorithm.getGrand(), Integer.MAX_VALUE);

            case "distance":
                return searchAlgorithm.listFilteredByMaxDist(searchAlgorithm.getGrand(), Integer.MAX_VALUE);

            case "review":
                return searchAlgorithm.listFilteredByMinRev(searchAlgorithm.getGrand(), 0);

            case "local":
                return searchAlgorithm.listFilteredByLocal(searchAlgorithm.getGrand());

            case "best":
                return searchAlgorithm.defaultBestOptions(searchAlgorithm.getGrand());

            default:
                return null;

        }

    }
}

