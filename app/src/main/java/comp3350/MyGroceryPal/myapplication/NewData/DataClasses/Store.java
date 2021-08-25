package comp3350.MyGroceryPal.myapplication.NewData.DataClasses;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;

import java.util.ArrayList;
import java.util.Objects;

/*
 * Store
 * has all the information related to a Store object
 */

public class Store  {
    private String name;
    private ArrayList<StoreItems> items;
    private float distance;
    private float review;
    private int totalNumberOfReviews;
    private boolean local;

    public Store(String name, float distance,float review,int totalNumberOfReviews,boolean local){
        this.name=name;
        this.distance=distance;
        this.review=review;
        this.totalNumberOfReviews=totalNumberOfReviews;
        this.local=local;
        items = new ArrayList<StoreItems>();

    }


    public Store(String name, float distance,float review,int totalNumberOfReviews,boolean local,ArrayList<StoreItems> theItems){
        this.name=name;
        this.distance=distance;
        this.review=review;
        this.totalNumberOfReviews=totalNumberOfReviews;
        this.local=local;
        items = new ArrayList<StoreItems>(); //initializing
        setItems(theItems);
    }
    public void setItems(ArrayList<StoreItems> theItems){
        for(int i = 0; i < theItems.size(); i++){
            items.add(theItems.get(i));
        }
    }

    public ArrayList<StoreItems> getItems(){
        return items;
    }

    public String getName() {
        return name;
    }
    public float getReview() {return review;}
    public float getDistance(){return distance;}
    public boolean getLocal(){return local;}
    public int getTotalNumberOfReviews()
    {
        return totalNumberOfReviews;
    }

    public void setTotalNumberOfReviews(int totalNumberOfReviews) {
        this.totalNumberOfReviews = totalNumberOfReviews;
    }

    public void updateReviewRating( float score){
        review = ((((review*totalNumberOfReviews)+score))/(totalNumberOfReviews+1));

    }

    public void setReview(float review) {
        this.review = review;
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int hashCode()
    {
        return Objects.hash(name, distance);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean equals(final Store other)
    {
        return Objects.equals(this.name, other.getName()) &&
                Objects.equals(this.distance, other.getDistance());
    }

}
