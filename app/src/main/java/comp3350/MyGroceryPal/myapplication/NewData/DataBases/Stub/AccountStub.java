package comp3350.MyGroceryPal.myapplication.NewData.DataBases.Stub;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

public class AccountStub implements AccountPersistence {
    public AccountStub(){

    }
    @Override
    public boolean authenticate(User a) {
       return Database.authenticate(a.getUsername(),a.getPassword());
    }

    @Override
    public void add(User a) {
            Database.insertAccounts(a.getUsername(),a.getPassword(),a.getName());
    }

    @Override
    public boolean usernameExists(User a) {

        return Database.doesExistAccount(a.getName());
    }


}
