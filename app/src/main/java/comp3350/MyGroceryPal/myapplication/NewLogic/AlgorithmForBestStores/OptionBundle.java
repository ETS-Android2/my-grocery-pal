package comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;

/*
 * OptionBundle
 * The class that bundles a list of ShopOptions along with its information
 * such as max distance, average review, total price, and all local or not.
 */

public class OptionBundle  {
    private ArrayList<ShopOption> shops;
    private float maxDistance;
    private float averageReview;
    private float totalReview;
    private double totalPrice;
    private boolean hasLocal;
    private int numDistinctStores;

    public OptionBundle() {
        shops = new ArrayList<ShopOption>();
        maxDistance = 0;
        averageReview = 0;
        totalPrice = 0;
        totalReview = 0;
        numDistinctStores = 0;
        hasLocal = true;
    }

    public OptionBundle(ArrayList<ShopOption> theShops, float maxD, float totalR, double totalP, boolean containsLocal) {
        numDistinctStores = computeDistinctStoresList(theShops).size();
        shops = theShops;
        maxDistance = maxD;
        totalReview = totalR;
        totalPrice = totalP;
        hasLocal = containsLocal;
    }

    public void setShops(ArrayList<ShopOption> theShops) {
        shops = theShops;
    }

    // If a ShopOption is added, we need to keep track of its information too
    public void addShopOption(ShopOption newShop, int amountGrocItem) {
        shops.add(newShop);
        numDistinctStores = computeDistinctStoresList(shops).size();
        totalPrice += roundTwoDecimalPlaces(amountGrocItem * newShop.getItems().getPrice());
        totalPrice = roundTwoDecimalPlaces(totalPrice);
        maxDistance = Math.max(maxDistance, newShop.getStore().getDistance());
        totalReview += newShop.getStore().getReview();
        if(!newShop.getStore().getLocal()) {
            hasLocal = false;
        }
    }

    // Clones OptionBundle
    public OptionBundle clone() {
        ArrayList<ShopOption> cloneShops = (ArrayList<ShopOption>)shops.clone();
        return new OptionBundle(cloneShops, maxDistance, totalReview, totalPrice, hasLocal);
    }

    // Returns the average review by calculating the average first
    public float getAverageReview() {
        if(shops.size() > 0) {
            averageReview = (float)(roundTwoDecimalPlaces(totalReview / shops.size()));
        }
        return averageReview;
    }

    public int getNumDistinctStores() {
        return numDistinctStores;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public float getMaxDistance() {
        return maxDistance;
    }

    public boolean allLocal() {
        return hasLocal;
    }

    public ArrayList<ShopOption> getShopOptions() {
        return shops;
    }

    private static double roundTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public ArrayList<String> computeDistinctStoresList(ArrayList<ShopOption> theShops) {
        ArrayList<String> tempDistinctNameStores = new ArrayList<String>();
        for(int i = 0; i < theShops.size(); i++) {
            if(theShops.get(i) != null) {
                String theStoreName = theShops.get(i).getStore().getName();
                if (!tempDistinctNameStores.contains(theStoreName))
                    tempDistinctNameStores.add(theStoreName);
            }
        }

        return tempDistinctNameStores;
    }

    public ArrayList<String> computeDistinctStoresList() {
        ArrayList<String> tempDistinctNameStores = new ArrayList<String>();
        for(int i = 0; i < shops.size(); i++) {
            if(shops.get(i) != null) {
                String theStoreName = shops.get(i).getStore().getName();
                if (!tempDistinctNameStores.contains(theStoreName))
                    tempDistinctNameStores.add(theStoreName);
            }
        }

        return tempDistinctNameStores;
    }

    public ArrayList<String> returnStoreItemsByStore(String store){
        ArrayList<String> storeItems= new ArrayList<String>();

        for (int i=0;i<shops.size();i++){
            if (shops.get(i)!=null&&shops.get(i).getStore().getName().equals(store)){
                storeItems.add(shops.get(i).getItems().getName());

            }
        }

        return storeItems;
    }
    //acts as a parallel arraylist to returnStoreItemsByStore
    public ArrayList<Double> returnPricesByStore(String store){

        ArrayList <Double> price= new ArrayList<Double>();
        for (int i=0;i<shops.size();i++){
            if (shops.get(i)!=null&&shops.get(i).getStore().getName().equals(store)){

                price.add(shops.get(i).getItems().getPrice());
            }
        }

        return price;
    }


}
