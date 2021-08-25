package comp3350.MyGroceryPal.myapplication.NewData.DataBases.hsqldb;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Persistence.NewStorePersistence;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.StoreItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreHSQLDB implements NewStorePersistence {
    private final String dbPath;

    public StoreHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }
    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Store fromResultSet(final ResultSet rs)throws SQLException{
        final String name = rs.getString("name");

        final float distance = rs.getFloat("distance");
        final float review = rs.getFloat("review");
        final int amountReview = rs.getInt("amountofreview");
        final boolean local = rs.getBoolean("local");
        return new Store(name,distance,review,amountReview,local);
    }

    @Override
    public List<Store> getStoreList() {
        final List<Store> stores = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM stores");
            ResultSet rs2=null;
            PreparedStatement st2 ;
            st2=c.prepareStatement("SELECT * FROM storeinventories WHERE storename=?");

            while (rs.next()) {
                final Store store = fromResultSet(rs);
                stores.add(store);
                st2.setString(1,store.getName());
                rs2=st2.executeQuery();



                while(rs2.next()){
                    store.getItems().add(new StoreItems(rs2.getString("itemname"),rs2.getInt("amount"),rs2.getString("type"),rs2.getFloat("price")));
                }
            }
            rs.close();
            st.close();
            st2.close();
            rs2.close();

            return stores;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }
    @Override
    public Store getStore(String name){
        final List<Store> storesList = new ArrayList<Store>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM stores WHERE name=?");
            st.setString(1, name);

            final ResultSet rs = st.executeQuery();
            while (rs.next()){
                final Store store = fromResultSet(rs);
                storesList.add(store);
            }


            rs.close();
            st.close();
            assert (storesList.size()==1);
            return storesList.get(0);
        }
        catch (final SQLException e)
        {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void updateReview(Store store,float score)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE stores SET review = ? WHERE name = ?");
            store.updateReviewRating(score);
            st.setString(1, String.valueOf(store.getReview()));
            st.setString(2, store.getName());

            st.executeUpdate();


        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }


    }

    @Override
    public void incrementAmount(Store store)
    {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("UPDATE stores SET amountofreview = ? WHERE name = ?");
            st.setString(1, String.valueOf(store.getTotalNumberOfReviews()+1));
            st.setString(2, store.getName());


            st.executeUpdate();


        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }


    }

}
