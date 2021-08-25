package comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Items;

//represents all items a store can sell
public class StoreItems extends Items {
    private double price;
    public StoreItems(String name,int amount,String type,double price){
        super(name,amount,type);
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){this.price=price; }
    public void setAmount(int amount){this.amount=amount;}


}
