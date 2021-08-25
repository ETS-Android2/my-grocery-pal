package comp3350.MyGroceryPal.myapplication.Items;

import org.junit.Before;
import org.junit.Test;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void validUserNameAndPassword() {
        assertFalse(new User("","","").validUserNameAndPassword(true));
        assertFalse(new User("asdasfa","","").validUserNameAndPassword(true));
        assertFalse(new User("safass","fdafsafd","").validUserNameAndPassword(true));
        assertFalse(new User("","sadfsafd","agsasdf").validUserNameAndPassword(true));
        assertFalse(new User("2342432","234","235345").validUserNameAndPassword(true));
        assertFalse(new User("234243777777777777772","234","235345").validUserNameAndPassword(true));
        assert(new User("2342432","2sgfsdfg4","235fsgd345").validUserNameAndPassword(true));
        assert(new User("2342432","2sgfsdfg4","235").validUserNameAndPassword(false));
    }
}