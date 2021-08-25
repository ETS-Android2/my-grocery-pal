package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import android.accounts.Account;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

import java.util.ArrayList;

public class Database {
    //store database

    private static ArrayList<ArrayList<GroceryListItems>> groceryListItemsOrderedByType;
    private static ArrayList<Store> storeList;
    private static ArrayList<String> groceryItemTypeList;
    private static ArrayList<User> accountsList;
    private static ArrayList<Recipe> recipes;

    //initializes all our data
    public Database(){

        groceryListItemsOrderedByType = new ArrayList<ArrayList<GroceryListItems>>();
        storeList= new ArrayList<Store>();
        groceryItemTypeList=new ArrayList<String>();
        accountsList= new ArrayList<User>();
        recipes = new ArrayList<Recipe>();
        groceryItemTypeList.add("Fruits and Vegetables");
        groceryItemTypeList.add("Dairy");
        groceryItemTypeList.add("Alcohol");
        groceryItemTypeList.add("Meat");
        groceryItemTypeList.add("Grain");
        intitializeGroceryListItemsOrderedByType();
        insertGroceryListItem("Banana",groceryItemTypeList.get(0));
        insertGroceryListItem("Orange",groceryItemTypeList.get(0));
        insertGroceryListItem("Ice Cream",groceryItemTypeList.get(1));
        insertGroceryListItem("Apple",groceryItemTypeList.get(0));
        insertGroceryListItem("Apple Cider",groceryItemTypeList.get(2));
        insertGroceryListItem("Blueberries",groceryItemTypeList.get(0));
        insertGroceryListItem("Avocado",groceryItemTypeList.get(0));
        insertGroceryListItem("Coconut",groceryItemTypeList.get(0));
        insertGroceryListItem("Pickle",groceryItemTypeList.get(0));
        insertGroceryListItem("Lemon",groceryItemTypeList.get(0));
        insertGroceryListItem("Mango",groceryItemTypeList.get(0));
        insertGroceryListItem("Mandarin",groceryItemTypeList.get(0));
        insertGroceryListItem("Pear",groceryItemTypeList.get(0));
        insertGroceryListItem("Carrot",groceryItemTypeList.get(0));
        insertGroceryListItem("Broccoli",groceryItemTypeList.get(0));
        insertGroceryListItem("Cauliflower",groceryItemTypeList.get(0));
        insertGroceryListItem("Cucumber",groceryItemTypeList.get(0));
        insertGroceryListItem("Lettuce",groceryItemTypeList.get(0));
        insertGroceryListItem("Green pepper",groceryItemTypeList.get(0));
        insertGroceryListItem("Mushroom",groceryItemTypeList.get(0));
        insertGroceryListItem("Onion",groceryItemTypeList.get(0));
        insertGroceryListItem("Tomato",groceryItemTypeList.get(0));
        insertGroceryListItem("Milk",groceryItemTypeList.get(1));
        insertGroceryListItem("Butter",groceryItemTypeList.get(1));
        insertGroceryListItem("Cheese",groceryItemTypeList.get(1));
        insertGroceryListItem("Yogurt",groceryItemTypeList.get(1));
        insertGroceryListItem("Sour cream",groceryItemTypeList.get(1));
        insertGroceryListItem("Casein",groceryItemTypeList.get(1));
        insertGroceryListItem("Pork",groceryItemTypeList.get(1));
        insertGroceryListItem("Beef",groceryItemTypeList.get(3));
        insertGroceryListItem("Chicken",groceryItemTypeList.get(3));
        insertGroceryListItem("Turkey",groceryItemTypeList.get(3));
        insertGroceryListItem("Lamb",groceryItemTypeList.get(3));
        insertGroceryListItem("Venison",groceryItemTypeList.get(3));
        insertGroceryListItem("Rabbit",groceryItemTypeList.get(3));
        insertGroceryListItem("Duck",groceryItemTypeList.get(3));
        insertGroceryListItem("Rice",groceryItemTypeList.get(4));
        insertGroceryListItem("Buckwheat",groceryItemTypeList.get(4));
        insertGroceryListItem("Oatmeal",groceryItemTypeList.get(4));
        insertGroceryListItem("Barley",groceryItemTypeList.get(4));
        insertGroceryListItem("Whole bread",groceryItemTypeList.get(4));
        insertGroceryListItem("White bread",groceryItemTypeList.get(4));



        insertStore("Walmart",50.9f, 4.2f,false);
        insertStore("Super Store",40.2f, 3.8f,false);
        insertStore("Safeway",30.5f,4.5f,false);
        insertStore("Costco",73.2f,3.5f,false);
        insertStore("Local Store",10.9f, 3.5f,true);
        insertStore("Some Store in Asia",9999f, 5.0f,true);

        insertStoreItem(0,"Apple",5.99f,500);
        insertStoreItem(0,"Avocado",4.49f,123);
        insertStoreItem(0,"Orange",3.0f,153);
        insertStoreItem(0,"Coconut",11.99f,132);
        insertStoreItem(0,"Pickle",4.39f,225);
        insertStoreItem(0,"Mandarin",7.99f,534);
        insertStoreItem(0,"Broccoli",6.02f,152);
        insertStoreItem(0,"Oatmeal",15.32f,1235);
        insertStoreItem(0,"Beef",18.4f,1234);
        insertStoreItem(0,"Pork",15.0f,132);
        insertStoreItem(0,"Chicken",17f,536);
        insertStoreItem(0,"Mushroom",0.7f,381);
        insertStoreItem(0,"Onion",3.99f,139);
        insertStoreItem(0,"Tomato",3.85f,243);
        insertStoreItem(0,"Rice",15f,328);
        insertStoreItem(0,"White bread",18.2f,203);
        insertStoreItem(0,"Barley",15.99f,123);
        insertStoreItem(0,"Venison",10.99f,532);
        insertStoreItem(0,"Yogurt",7.99f,153);
        insertStoreItem(0,"Cheese",9.99f,123);
        insertStoreItem(0,"Lettuce",5.62f,452);
        insertStoreItem(0,"Cucumber",6.99f,126);
        insertStoreItem(0,"Sour cream",1.53f,123);
        insertStoreItem(0,"Rabbit",5.31f,354);

        insertStoreItem(1,"Apple",5.99f,335);
        insertStoreItem(1,"Avocado",3.49f,534);
        insertStoreItem(1,"Orange",6.0f,353);
        insertStoreItem(1,"Coconut",10.99f,165);
        insertStoreItem(1,"Pickle",7.39f,610);
        insertStoreItem(1,"Carrot",7.99f,310);
        insertStoreItem(1,"Broccoli",3.02f,155);
        insertStoreItem(1,"Lemon",4.32f,182);
        insertStoreItem(1,"Beef",21.4f,122);
        insertStoreItem(1,"Pork",15.0f,194);
        insertStoreItem(1,"Lamb",18f,117);
        insertStoreItem(1,"Mushroom",0.9f,358);
        insertStoreItem(1,"Onion",7.99f,321);
        insertStoreItem(1,"Tomato",1.85f,431);
        insertStoreItem(1,"Rice",17f,220);
        insertStoreItem(1,"White bread",31.2f,150);
        insertStoreItem(1,"Barley",11.99f,254);
        insertStoreItem(1,"Venison",15.99f,127);
        insertStoreItem(1,"Yogurt",9.99f,134);
        insertStoreItem(1,"Cheese",3.99f,513);
        insertStoreItem(1,"Lettuce",9.62f,116);
        insertStoreItem(1,"Cucumber",9.99f,263);
        insertStoreItem(1,"Sour cream",15.53f,117);
        insertStoreItem(1,"Venison",30.31f,214);

        insertStoreItem(2,"Banana",1.51f,116);
        insertStoreItem(2,"Ice Cream",1.23f,253);
        insertStoreItem(2,"Apple",3.23f,126);
        insertStoreItem(2,"Apple Cider",5.21f,153);
        insertStoreItem(2,"Avocado",3.51f,619);
        insertStoreItem(2,"Lemon",4.42f,134);
        insertStoreItem(2,"Mandarin",2.43f,111);
        insertStoreItem(2,"Pear",3.34f,180);
        insertStoreItem(2,"Broccoli",6.76f,155);
        insertStoreItem(2,"Lettuce",6.13f,278);
        insertStoreItem(2,"Green pepper",22.13f,113);
        insertStoreItem(2,"Tomato",6.41f,456);
        insertStoreItem(2,"Milk",2.35f,711);
        insertStoreItem(2,"Cheese",5.3f,112);
        insertStoreItem(2,"Pork",10.2f,536);
        insertStoreItem(2,"Beef",11.31f,221);
        insertStoreItem(2,"Chicken",7.35f,211);
        insertStoreItem(2,"Turkey",13.31f,553);
        insertStoreItem(2,"Lamb",26.25f,122);
        insertStoreItem(2,"Venison",18.16f,131);
        insertStoreItem(2,"Duck",19.51f,125);
        insertStoreItem(2,"Buckwheat",31.33f,235);
        insertStoreItem(2,"Barley",16.33f,145);
        insertStoreItem(2,"Whole bread",5.33f,631);
        insertStoreItem(2,"White bread",5.33f,700);

        insertStoreItem(3,"Banana",1.41f,130);
        insertStoreItem(3,"Orange",2.34f,143);
        insertStoreItem(3,"Ice Cream",2.23f,516);
        insertStoreItem(3,"Apple",8.23f,623);
        insertStoreItem(3,"Apple Cider",2.51f,523);
        insertStoreItem(3,"Blueberries",4.14f,614);
        insertStoreItem(3,"Avocado",5.61f,419);
        insertStoreItem(3,"Coconut",10.43f,616);
        insertStoreItem(3,"Pickle",5.61f,556);
        insertStoreItem(3,"Lemon",7.42f,456);
        insertStoreItem(3,"Mango",6.34f,714);
        insertStoreItem(3,"Mandarin",3.43f,411);
        insertStoreItem(3,"Pear",3.34f,611);
        insertStoreItem(3,"Carrot",1.51f,721);
        insertStoreItem(3,"Broccoli",5.76f,415);
        insertStoreItem(3,"Cauliflower",4.39f,815);
        insertStoreItem(3,"Cucumber",11.15f,111);
        insertStoreItem(3,"Lettuce",4.13f,618);
        insertStoreItem(3,"Green pepper",12.13f,223);
        insertStoreItem(3,"Mushroom",1.14f,332);
        insertStoreItem(3,"Onion",5.22f,314);
        insertStoreItem(3,"Tomato",5.41f,516);
        insertStoreItem(3,"Milk",1.35f,411);
        insertStoreItem(3,"Butter",4.31f,316);
        insertStoreItem(3,"Cheese",3.3f,539);
        insertStoreItem(3,"Yogurt",6.3f,1238);
        insertStoreItem(3,"Sour cream",4.2f,521);
        insertStoreItem(3,"Casein",5.51f,327);
        insertStoreItem(3,"Pork",11.2f,515);
        insertStoreItem(3,"Beef",21.31f,312);
        insertStoreItem(3,"Chicken",5.35f,361);
        insertStoreItem(3,"Turkey",23.31f,123);
        insertStoreItem(3,"Lamb",22.25f,512);
        insertStoreItem(3,"Venison",16.16f,351);
        insertStoreItem(3,"Rabbit",14.32f,511);
        insertStoreItem(3,"Duck",17.51f,310);
        insertStoreItem(3,"Rice",12.23f,252);
        insertStoreItem(3,"Buckwheat",32.33f,500);
        insertStoreItem(3,"Oatmeal",31.33f,321);
        insertStoreItem(3,"Barley",13.33f,623);
        insertStoreItem(3,"Whole bread",5.33f,316);
        insertStoreItem(3,"White bread",5.33f,537);

        insertStoreItem(4,"Banana",3.41f,413);
        insertStoreItem(4,"Apple",5.23f,213);
        insertStoreItem(4,"Avocado",8.61f,511);
        insertStoreItem(4,"Mandarin",5.43f,315);
        insertStoreItem(4,"Tomato",8.21f,312);
        insertStoreItem(4,"Cheese",3.3f,139);
        insertStoreItem(4,"Yogurt",3.3f,128);
        insertStoreItem(4,"Sour cream",5.2f,510);
        insertStoreItem(4,"Casein",7.51f,113);
        insertStoreItem(4,"Pork",21.2f,618);
        insertStoreItem(4,"Venison",26.16f,311);
        insertStoreItem(4,"Rabbit",24.32f,711);
        insertStoreItem(4,"Duck",27.51f,310);
        insertStoreItem(4,"Rice",12.23f,132);
        insertStoreItem(4,"Buckwheat",22.33f,310);
        insertStoreItem(4,"Oatmeal",11.33f,131);
        insertStoreItem(4,"Barley",23.33f,517);

        insertStoreItem(5,"Apple",2.23f,513);
        insertStoreItem(5,"Apple Cider",3.51f,413);
        insertStoreItem(5,"Blueberries",4.14f,214);
        insertStoreItem(5,"Avocado",6.61f,526);
        insertStoreItem(5,"Lemon",15.42f,316);
        insertStoreItem(5,"Mango",9.34f,515);
        insertStoreItem(5,"Mandarin",9.43f,321);
        insertStoreItem(5,"Pear",12.34f,517);
        insertStoreItem(5,"Onion",12.22f,612);
        insertStoreItem(5,"Tomato",14.41f,312);
        insertStoreItem(5,"Pork",17.2f,235);
        insertStoreItem(5,"Beef",27.31f,112);
        insertStoreItem(5,"Chicken",15.35f,611);
        insertStoreItem(5,"Turkey",23.31f,128);
        insertStoreItem(5,"Lamb",22.25f,615);
        insertStoreItem(5,"Venison",16.16f,611);
        insertStoreItem(5,"Rabbit",18.32f,713);
        insertStoreItem(5,"Duck",36.51f,916);
        insertStoreItem(5,"Rice",27.23f,834);

        insertAccounts("Red Ranger","REDDY","REDBEARD");
        insertAccounts("Blue Ranger","Blueberry","Bluebeard");
        insertAccounts("Green Ranger","Greg","GreenNinja");
        insertAccounts("Yellow Ranger","Yesland","Yellow spider");
        insertAccounts("Pink Ranger","PINK KINP","PINK NULL");


        Recipe one =createRecipe("Super Secret Recipe","A secret ingredients that gives a taste you will never forget. The secret is it tastes bad");
        addItemToRecipe(one,groceryListItemsOrderedByType.get(0).get(1));
        addItemToRecipe(one,groceryListItemsOrderedByType.get(3).get(2));
        addItemToRecipe(one,groceryListItemsOrderedByType.get(1).get(5));
        addStepsToRecipe(one,"1: Mix all ingredients well for 45 minutes");
        addStepsToRecipe(one,"2: Let it cook in water for 45 minutes");
        addStepsToRecipe(one,"3: Done! Now ready to serve!");


        Recipe two = createRecipe("Fruit Salad","A regular but sweet salad");
        addItemToRecipe(two,groceryListItemsOrderedByType.get(0).get(1));
        addItemToRecipe(two,groceryListItemsOrderedByType.get(0).get(3));
        addItemToRecipe(two,groceryListItemsOrderedByType.get(0).get(9));
        addItemToRecipe(two,groceryListItemsOrderedByType.get(0).get(11));
        addItemToRecipe(two,groceryListItemsOrderedByType.get(0).get(14));
        addStepsToRecipe(two,"1: Cut all your fruits into small pieces");
        addStepsToRecipe(two,"2: Mix into a Bowl");

        Recipe three = createRecipe("American BBQ","Getting ready to have a BBQ? This recipe got you covered");
        addItemToRecipe(three, groceryListItemsOrderedByType.get(3).get(1));
        addItemToRecipe(three, groceryListItemsOrderedByType.get(3).get(4));
        addItemToRecipe(three, groceryListItemsOrderedByType.get(3).get(5));
        addItemToRecipe(three, groceryListItemsOrderedByType.get(3).get(6));
        addStepsToRecipe(three,"1: Put all the meat into a blender and blend for 5 minutes");
        addStepsToRecipe(three,"2: Roast on a barbeque");

    }


    public static Recipe createRecipe(String name, String desc){
        if (name !=null && desc!=null) {
            Recipe temp = new Recipe(name, desc, new ArrayList<GroceryListItems>(), new ArrayList<String>());
            recipes.add(temp);
            return temp;
        }
        return null;
    }

    public static void addItemToRecipe(Recipe r,GroceryListItems g){
        r.getIngredients().add(g);
    }

    public static void addStepsToRecipe(Recipe r, String s){
        r.getSteps().add(s);
    }

    public static ArrayList<String> returnGroceryListTypeList(){ return groceryItemTypeList; }

    public static ArrayList<GroceryListItems> returnGroceryItemListByType(String type){
        if(groceryItemTypeList.indexOf(type)==-1){
            return null;
        }
        return groceryListItemsOrderedByType.get(groceryItemTypeList.indexOf(type));
    }

    private static void intitializeGroceryListItemsOrderedByType(){
        for (int i=0;i<groceryItemTypeList.size();i++){
            groceryListItemsOrderedByType.add(new ArrayList<GroceryListItems>());
        }
    }

    public static ArrayList<GroceryListItems> returnGroceryListItemsByName(String name){
        ArrayList<GroceryListItems> GLIbyName = new ArrayList<GroceryListItems>();
        for (int i=0;i<groceryListItemsOrderedByType.size();i++){
            for (int j=0;j<groceryListItemsOrderedByType.get(i).size();j++){
                if(groceryListItemsOrderedByType.get(i).get(j).getName().toLowerCase().contains(name.toLowerCase())){
                    GLIbyName.add(groceryListItemsOrderedByType.get(i).get(j));
                }
            }
        }
        return GLIbyName;
    }

    //inserts item into grocery items list using seperate changing by type
    public static boolean insertGroceryListItem(String name,String type) {
        boolean exist=false;
        if(name==null||type==null||groceryItemTypeList.indexOf(type)==-1){
            return false;
        }

        groceryListItemsOrderedByType.get(groceryItemTypeList.indexOf(type)).add(new GroceryListItems(name, 1, type));

        return true;
    }




    public static boolean insertStoreItem(int storeIndex, String item, float price, int amount){
        if(!(storeIndex>=0&&storeIndex<storeList.size()&&amount>=0&&price>0&&item!=null)){
            return false;
        }
        String type=returnType(item);
        if(type!=null) {
            storeList.get(storeIndex).getItems().add(new StoreItems(item,amount,type,price));
            return true;
        }
        return false;
    }

    //return a grocery list items type given its name

    public static String returnType(String name){
        if (name==null){
            return null;
        }
        for (int i = 0; i< groceryListItemsOrderedByType.size(); i++){
            for (int j = 0; j< groceryListItemsOrderedByType.get(i).size(); j++){
                if (groceryListItemsOrderedByType.get(i).get(j).getName().equals(name)){
                    return groceryListItemsOrderedByType.get(i).get(j).getType();
                }
            }
        }
        return null;
    }

    public static ArrayList<Recipe> getRecipes(){
        return recipes;
    }

    public static Recipe insertRecipes(Recipe r){
        recipes.add(r);
        return r;
    }

    public static void removeRecipe(Recipe r){
        recipes.remove(r);
    }


    public static Recipe getRecipeByName(String name){
        for (int i=0;i<recipes.size();i++){
            if (recipes.get(i).getName().equals(name)){
                return recipes.get(i);
            }
        }
        return null;
    }
    public static boolean insertStore(String name,float distance,float review,boolean local){
        if(name==null||distance<0||review<0){
            return false;
        }
        if(!doesExistStoreList(name)){
            storeList.add(new Store(name,distance,review,1821,local,new ArrayList<StoreItems>()));
            return true;
        }
        return false;
    }

    public static boolean insertAccounts(String username, String password, String name){
        if (username==null||password==null||name==null){
            return false;
        }
        if (!doesExistAccount(username)){
            accountsList.add(new User(username, password,name));
            return true;
        }
        return false;
    }


    public static boolean doesExistAccount(String username ){
        if (username==null){
            return false;
        }

        for (int i=0;i<accountsList.size();i++){

            if (accountsList.get(i).getUsername().equals(username)){

                return true;
            }
        }
        return false;
    }

    public static boolean authenticate(String username,String password ){
        if (username==null||password==null){
            return false;
        }

        for (int i=0;i<accountsList.size();i++){
            if (accountsList.get(i).getUsername().equals(username)&&accountsList.get(i).getPassword().equals(password) ){
                return true;
            }
        }
        return false;
    }

    //returns true if we have a store with that name in our database
    public static boolean doesExistStoreList(String store){
        if (store==null){
            return false;
        }

        for (int i=0;i<storeList.size();i++){
            if (storeList.get(i).getName().equals(store)){
                return true;
            }
        }
        return false;
    }



    public static ArrayList<ArrayList<GroceryListItems>> returnGroceryListItems(){
        return groceryListItemsOrderedByType;
    }

    public static ArrayList<Store> getStoreList(){

        return storeList;
    }

    public static void updateReview(Store store, float score){
        store.updateReviewRating(score);

    }

    public static void incrementAmount(Store store){
        store.setTotalNumberOfReviews(store.getTotalNumberOfReviews()+1);
    }

    public static Store getStore(String store){
        for (int i=0;i<storeList.size();i++){
            if(store.equals(storeList.get(i).getName())){
                return storeList.get(i);
            }
        }
        return null;
    }


}
