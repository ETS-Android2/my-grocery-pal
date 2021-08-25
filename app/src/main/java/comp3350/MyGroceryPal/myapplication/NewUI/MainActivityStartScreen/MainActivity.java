package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;


import comp3350.MyGroceryPal.myapplication.NewData.Application.Main;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeList;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.Database;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessGroceryItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStores;
import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessAccount;

import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    NewAccessGroceryItems newAccessGroceryItems;
    NewAccessStores newAS;
    AccessRecipeList recipe;
    NewAccessAccount newAccessAccount;
    public static boolean signIn=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Database database= new Database();
        super.onCreate(savedInstanceState);
        //comment this out in order to switch between the real and fake database
        copyDatabaseToDevice();
        //responsible for hosting the navigation graph na
        setContentView(R.layout.activity_main);

        //makes connection at the beginning so no future HSQLDB bugs happens
        newAccessGroceryItems = new NewAccessGroceryItems();
        newAS = new NewAccessStores();
        recipe = new AccessRecipeList();
        newAccessAccount = new NewAccessAccount();

        //sets up the bottom nav bar
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.navs_fragment);
        NavigationUI.setupWithNavController(bottomNav, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.output ||
                        destination.getId() == R.id.storeStatistics ||
                        destination.getId() == R.id.noStoresFragment ||
                        destination.getId() == R.id.accountFragment ||
                        destination.getId() == R.id.loginFragment ||
                        destination.getId() == R.id.registerFragment) {
                    bottomNav.setVisibility(View.GONE);
                }
                else {
                    bottomNav.setVisibility(View.VISIBLE);
                }
            }
        });



    }

    private void copyDatabaseToDevice() {
        //connects the databse
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);
            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());
        } catch (final IOException e) {
            System.out.println("Unable to access application data: "+e.getMessage());
        }
    }


    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }




}

