package comp3350.MyGroceryPal.myapplication.NewData.DataBases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

import static org.mockito.Mockito.*;

public class NewAccessAccountTest {
    private NewAccessAccount newAccessAccount;
    private AccountPersistence accountPersistence;
    @Before
    public void setUp() throws Exception {


        accountPersistence = mock(AccountPersistence.class);
        newAccessAccount = new NewAccessAccount(accountPersistence);
    }

    @Test
    //this test will test all the methods
    public void test1(){
        User user = new User("Amy","Amy'sPassword","Damian");
        User allDifferent = new User("Billy","BillyPass","asd");

        newAccessAccount.add(user);
        verify(accountPersistence).add(user);

        assertFalse(newAccessAccount.authenticate(allDifferent));
        verify(accountPersistence).authenticate(allDifferent);

        assertFalse(newAccessAccount.usernameExists(allDifferent));
        verify(accountPersistence).usernameExists(allDifferent);

        when (accountPersistence.authenticate(null)).thenReturn(true);
        assert (newAccessAccount.authenticate(null));

        when (accountPersistence.usernameExists(null)).thenReturn(true);
        assert (newAccessAccount.usernameExists(null));
    }


}