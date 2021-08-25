package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import comp3350.MyGroceryPal.myapplication.NewData.Application.Services;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

public class NewAccessAccount {
    private AccountPersistence accountPersistence;



    public NewAccessAccount()
    {
        this(Services.getAccountPersistence());
    }

    public NewAccessAccount(final AccountPersistence newAccountPersistence){

        this.accountPersistence = newAccountPersistence;

    }

    public boolean authenticate(User a)
    {
        return accountPersistence.authenticate(a);
    }

    public boolean usernameExists(User a)
    {
        return accountPersistence.usernameExists(a);
    }

    public void add(User a)
    {

        accountPersistence.add(a);
    }




}
