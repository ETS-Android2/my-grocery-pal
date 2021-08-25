package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence;


import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

public interface AccountPersistence {

    boolean authenticate(User a);
    void add(User a);
    boolean usernameExists(User a);

}
