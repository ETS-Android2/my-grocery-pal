package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database;
    @Before
    public void setUp() throws Exception {
        database= new Database();
        assertNotNull(database);
    }

    @Test
    public void returnGroceryListTypeList() {
        assertNotNull(Database.returnGroceryListTypeList());
        assert(Database.returnGroceryListTypeList().contains("Dairy"));
        assert(Database.returnGroceryListTypeList().contains("Meat"));
        assertFalse(Database.returnGroceryListTypeList().contains("Does Not Exist"));
    }

    @Test
    public void returnGroceryItemListByType() {
        assertNotNull(Database.returnGroceryItemListByType("Meat"));
        assertNull(Database.returnGroceryItemListByType("Not Exist"));
        assert(Database.returnGroceryItemListByType("Fruits and Vegetables").get(0).getType().equals("Fruits and Vegetables"));
        assertFalse(Database.returnGroceryItemListByType("Fruits and Vegetables").get(0).getType().equals("Dairy"));
    }

    @Test
    public void returnGroceryListItemsByName() {
        assertNotNull(Database.returnGroceryListItemsByName("Banana"));
        boolean bool=false;
        ArrayList<GroceryListItems> listByName = Database.returnGroceryListItemsByName("a");

        for (int i=0;i<listByName.size();i++){
            if (listByName.get(i).getName().equals("Apple")){
                bool=true;
            }
        }
        assert(bool);
        for (int i=0;i<listByName.size();i++){
            if (listByName.get(i).getName().equals("Milk")){
                bool=false;
            }
        }
        assert(bool);

    }

    @Test
    public void insertGroceryListItem() {
        assertFalse(Database.insertGroceryListItem("illegal","illegalType"));
        assertFalse(Database.returnType("illegal")=="illegalType");
        assert(Database.insertGroceryListItem("temp","Alcohol"));
        assertFalse(Database.insertGroceryListItem(null,"empty"));
        assertFalse(Database.insertGroceryListItem("empty",null));
        assertFalse(Database.insertGroceryListItem(null,null));
    }

    @Test
    public void insertStoreItem() {
        assertFalse(Database.insertStoreItem(-1,null,-1,-1));
        assertFalse(Database.insertStoreItem(-1,null,-1,9));
        assertFalse(Database.insertStoreItem(-1,null,9,-1));
        assertFalse(Database.insertStoreItem(-1,"temp",-1,-1));
        assertFalse(Database.insertStoreItem(9,null,-1,-1));
        assertFalse(Database.insertStoreItem(9,"temp",-1,-1));
        assertFalse(Database.insertStoreItem(9,null,9,-1));
        assertFalse(Database.insertStoreItem(-1,null,9,9));
        assert(Database.insertStoreItem(4,"Apple Cider",5.6f,5));
        assertFalse(Database.insertStoreItem(4,"noItem",7,7));
    }

    @Test
    public void returnType() {
        assertNull(Database.returnType(null));
        assertNull(Database.returnType("Non existant"));
        assertEquals(Database.returnType("Milk"),"Dairy");
    }

    @Test
    public void insertStore() {
        assertFalse(Database.insertStore(null,-1,-1,false));
        assertFalse(Database.insertStore("a",-1,-1,false));
        assertFalse(Database.insertStore(null,2,-1,false));
        assertFalse(Database.insertStore(null,-1,2,false));
        assertFalse(Database.insertStore(null,2,2,false));
        assertFalse(Database.insertStore("a",2,-1,false));
        assertFalse(Database.insertStore("a",-1,2,false));
        assertFalse((Database.insertStore("Walmart",3,3,false)));
        assert(Database.insertStore("Fake Store",3,3,false));
    }

    @Test
    public void doesExistStoreList() {
        assertFalse(Database.doesExistStoreList(null));
        assertFalse(Database.doesExistStoreList("walmart"));
        assertFalse(Database.doesExistStoreList("nothing"));
        assert(Database.doesExistStoreList("Walmart"));
    }
    @Test
    public void doesExistAccount(){
        assertFalse(Database.doesExistAccount(null));
        assertFalse(Database.doesExistAccount("Black Ranger"));
        assert(Database.doesExistAccount("Blue Ranger"));
    }

    @Test
    public void authenticate(){
        assertFalse(Database.authenticate(null,null));
        assertFalse(Database.authenticate("Blue Ranger",null));
        assertFalse(Database.authenticate(null,"REDDY"));
        assertFalse(Database.authenticate("Black Ranger","PAS"));
        assert(Database.authenticate("Blue Ranger","Blueberry"));
    }

    @Test
    public void insertAccounts(){

        assertFalse(Database.insertAccounts(null,null,null));
        assertFalse(Database.insertAccounts(null,"",""));
        assertFalse(Database.insertAccounts("",null,""));
        assertFalse(Database.insertAccounts("","",null));
        assertFalse(Database.insertAccounts(null,"",null));
        assertFalse(Database.insertAccounts(null,null,null));
        assertFalse(Database.insertAccounts("Green Ranger","Greg","GreenNinja"));
        assertFalse(Database.insertAccounts("Green Ranger","Greg","GreenN"));
        assertFalse(Database.insertAccounts("Green Ranger","FakeName","GreenNinja"));
        assert(Database.insertAccounts("Brown Ranger","Greg","GreenNinja"));
        assert(Database.insertAccounts("Brown Ranger2","Gregwerw","GreenNinja"));
        assert(Database.insertAccounts("Brown Ranger3","Greg","GreenNdaadinja"));

    }


    @Test
    public void returnGroceryListItems() {
        assertNotNull(Database.returnGroceryListItems());
        assertEquals(Database.returnGroceryListItems().get(1).size(),8);
    }

    @Test
    public void getStoreList() {
        assertNotNull(Database.getStoreList());
        ArrayList<Store> storeList=Database.getStoreList();
        boolean con =false;
        for (int i=0;i<storeList.size();i++){
           if(storeList.get(i).getName().equals("Walmart")){
               con=true;
           }
        }
        assert(con);
    }


    @Test
    public void createRecipe(){
        assertNull(Database.createRecipe(null,"temp"));
        assertNull(Database.createRecipe("temp",null));
        assertNull(Database.createRecipe(null,null));
        assert (Database.createRecipe("name","desc").getName().equals("name"));
        assert (Database.createRecipe("name2","desc2").getDesc().equals("desc2"));
        boolean found = false;
        for (int i=0;i<Database.getRecipes().size();i++){
            if (Database.getRecipes().get(i).getName().equals("name2")&& Database.getRecipes().get(i).getDesc().equals("desc2")){
                found =true;
            }
        }
        assert (found);
    }

    @Test
    public void getRecipeByName(){
            assertNull(Database.getRecipeByName("DOESNOTEXISTLMAO"));
            assertNotNull(Database.getRecipeByName("Fruit Salad"));
    }

    @Test
    public void updateReview(){
        Store temp = new Store ("asd",5.66f,3.4f,1789,true);
       Database.updateReview(temp,4.5f);
        assert(temp.getReview()==3.4006145f);
    }

    @Test
    public void incrementAmount(){
        Store temp = new Store ("asd",5.66f,3.4f,1789,true);
        Database.incrementAmount(temp);
        assert (temp.getTotalNumberOfReviews()==1790);
    }


}