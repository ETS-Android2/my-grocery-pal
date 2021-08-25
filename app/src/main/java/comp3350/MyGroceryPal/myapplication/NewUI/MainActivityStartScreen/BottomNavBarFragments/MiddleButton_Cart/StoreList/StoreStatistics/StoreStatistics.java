package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList.StoreStatistics;


import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessStores;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Store;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.ShopOption;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse.GroceryItemsList.BrowseGroceryListItemsFragment;

import com.example.myapplication.R;

import java.util.ArrayList;


public class StoreStatistics extends Fragment implements ShopStatisticsAdapter.ViewItems ,ShopStatisticsAdapter.ReviewStores{

    RecyclerView rView;
    ShopStatisticsAdapter adapter;
    ArrayList<OptionBundle> listOfOptionBundles;
    OptionBundle optionBundle;
    NewAccessStores newAccessStores;
    ArrayList<String> listOfStores;
    int position;
    String filter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_store_statistics, container, false);

        //print statistics of the option bundle

        position = getArguments().getInt("position");
        newAccessStores = new NewAccessStores();
        filter = getArguments().getString("filter");

        listOfOptionBundles=searchAlgorithm.getDesiredList(filter);

        if(listOfOptionBundles !=null) {
            listOfOptionBundles.get(position);

            TextView review = view.findViewById(R.id.Review);
            review.setText("Review: " + String.valueOf(listOfOptionBundles.get(position).getAverageReview()));

            TextView price = view.findViewById(R.id.Price);
            price.setText("Price: $"+String.valueOf(listOfOptionBundles.get(position).getTotalPrice()));

            TextView distance = view.findViewById(R.id.Distance);
            distance.setText("Distance: " + String.valueOf(listOfOptionBundles.get(position).getMaxDistance()) + "km");

            TextView local = view.findViewById(R.id.Local);
            if (listOfOptionBundles.get(position).allLocal()) {
                local.setText("Local");
            }
            else {
                local.setText("Not Local");
            }

        }


            Button goBack = view.findViewById(R.id.GoBack);



        //goes back to the store list
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();

            }
        });


        optionBundle=listOfOptionBundles.get(position);
        listOfStores=listOfOptionBundles.get(position).computeDistinctStoresList();
        //sets layout of the list
        rView=view.findViewById(R.id.rView);

        adapter = new ShopStatisticsAdapter(listOfStores,this,this);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    @Override
    public void goToItems(String store) {


        Bundle bundle = new Bundle();
        bundle.putStringArrayList("items", optionBundle.returnStoreItemsByStore(store));
        bundle.putSerializable("price", optionBundle.returnPricesByStore(store));
        bundle.putInt("position",position);
        bundle.putString("filter", filter);
        bundle.putString("stores",store);
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_storeStatistics_to_listOfItemsPerStore, bundle);
    }

    //goes back to the store list
    public void goBack(){
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_storeStatsToOutput);
    }

    @Override
    public void review(String store) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup_review,null);
        final RatingBar bar =contactPopupView.findViewById(R.id.ratingBar);
        final Button setReview = contactPopupView.findViewById(R.id.setReview);
        alertDialogBuilder.setView(contactPopupView);


        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

        setReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Store s =newAccessStores.getStore(store);

                newAccessStores.updateReview(s,bar.getRating());
                newAccessStores.incrementAmount(s);
                dialog.dismiss();
            }
        }
        );
    }




}