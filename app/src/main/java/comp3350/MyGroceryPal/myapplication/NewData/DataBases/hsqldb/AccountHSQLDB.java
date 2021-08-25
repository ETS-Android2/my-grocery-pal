package comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.AccountPersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb.PersistenceException;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountHSQLDB implements AccountPersistence {
    private final String dbPath;

    public AccountHSQLDB(final String dbPath){ this.dbPath=dbPath; }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");

    }

    @Override
    public boolean authenticate(User a)
    {
        try (final Connection c = connection()){
            boolean ret = false;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT");
            while (rs.next() && !ret){
                final User user= new User(rs.getString("username"),rs.getString("password"),rs.getString("name"));
                if(user.getUsername().equals(a.getUsername())&&user.getPassword().equals(a.getPassword()))
                {
                    ret = true;
                }
            }
            rs.close();
            st.close();
            return ret;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

    public void add(User a) {
        try (final Connection c = connection()){
            final PreparedStatement st= c.prepareStatement("INSERT INTO account VALUES(?,?,?)");
            st.setString(1,a.getUsername());
            st.setString(2,a.getPassword());
            st.setString(3,a.getName());
            st.executeUpdate();
            st.close();
        }
        catch (final SQLException e) {
            throw new PersistenceException(e);
        }

    }

    @Override
    public boolean usernameExists(User a)
    {
        try (final Connection c = connection()){
            boolean ret = false;
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM ACCOUNT");
            while (rs.next() && !ret){
                final User user= new User(rs.getString("username"),rs.getString("password"),rs.getString("name"));

                if(user.getUsername().equals(a.getUsername()))
                {
                    ret = true;
                }
            }
            rs.close();
            st.close();
            return ret;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }



}
