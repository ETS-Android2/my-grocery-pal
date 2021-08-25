package comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items;


//an abstract class for all the other items
public abstract class Items  {
    protected String name;
    protected int amount;
    protected String type;

    public Items(String name,int amount,String type){
        this.name=name;
        this.type=type;
        this.amount=amount;
    }

    public String getName(){
        return name;
    }
    public int getAmount(){return amount; }
    public void setAmount(int s){amount=s;}
    public String getType(){return type;}
    public String print(){
        return name + " Amount: "+String.valueOf(amount)+" Type: "+type;
    }



}
