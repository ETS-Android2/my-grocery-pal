package comp3350.MyGroceryPal.myapplication.NewData.DataClasses;

public class User {
    private String username;
    private String password;
    private String name;


    public User(String username, String password, String name )
    {
        this.username=username;
        this.password=password;
        this.name=name;
    }

    public User(String username, String password)
    {
        this.username=username;
        this.password=password;
        this.name="";
    }

    public boolean validUserNameAndPassword(boolean includeName){
        return username.length() > 3 && username.length() <= 15 && password.length() > 3 && password.length() <= 15 &&(!includeName||( name.length()>3 && name.length()<=15));
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
