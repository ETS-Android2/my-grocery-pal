package comp3350.MyGroceryPal.myapplication.NewData.Application;


import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewGroceryItemPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.RecipeListPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.AccountStub;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.GroceryListItemStub;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.RecipeStub;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub.StoreListPersistenceStub;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.AccountHSQLDB;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.GroceryItemsHSQLDB;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.RecipesHSQLDB;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.StoreHSQLDB;

public class Services {
    private static NewGroceryItemPersistence groceryListItemPersistence=null;
    private static NewStorePersistence storePersistence=null;
    private static RecipeListPersistence recipeListPersistence=null;
    private static AccountPersistence accountPersistence=null;
    public static synchronized NewGroceryItemPersistence getGroceryListItemPersistence()
    {
        if (groceryListItemPersistence == null)
        {
            if(Main.getDBPathName().equals("groceryDB")){
                groceryListItemPersistence = new GroceryListItemStub();
            } else {
                groceryListItemPersistence = new GroceryItemsHSQLDB(Main.getDBPathName());
            }
        }


        return groceryListItemPersistence;
    }

    public static synchronized NewStorePersistence getStorePersistence()
    {
        if (storePersistence == null)
        {
            if(Main.getDBPathName().equals("groceryDB")){
                storePersistence= new StoreListPersistenceStub();
            } else {
                storePersistence = new StoreHSQLDB(Main.getDBPathName());
            }
        }


        return storePersistence;
    }

    public static synchronized RecipeListPersistence getRecipeListPersistence()
    {
        if (recipeListPersistence == null)
        {
            if(Main.getDBPathName().equals("groceryDB")){
                recipeListPersistence = new RecipeStub();

            } else {
                recipeListPersistence=new RecipesHSQLDB(Main.getDBPathName());
            }

        }


        return recipeListPersistence;
    }

    public static synchronized AccountPersistence getAccountPersistence()
    {
        if (accountPersistence == null)
        {
            if(Main.getDBPathName().equals("groceryDB")){
                accountPersistence = new AccountStub();

            } else {
                accountPersistence=new AccountHSQLDB(Main.getDBPathName());
            }

        }
        return accountPersistence;
    }
}

