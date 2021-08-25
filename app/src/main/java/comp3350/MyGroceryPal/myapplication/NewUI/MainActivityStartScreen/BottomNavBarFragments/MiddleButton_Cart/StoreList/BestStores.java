package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BestStores extends Fragment implements BestStoreAdapter.InfoButton {


    RecyclerView rView;
    BestStoreAdapter adapter;
    private static float budget = -1;
    //this is a list of option bundles that represent statistics about each combination of stores
    //produced by search Algorithm
    ArrayList<OptionBundle> theOptionBundles;
    //represents the current filter
    String filter;

    public BestStores() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_best_stores, container, false);
        rView=view.findViewById(R.id.rView);
        filter="none";
        //creates an exact copy of the list generated from the algorithm
        theOptionBundles= new ArrayList<OptionBundle>(searchAlgorithm.getGrand());


        //sets up layout for the list
        adapter = new BestStoreAdapter(theOptionBundles, this);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));


        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });

        //every method like this essentially rearranges the list from gretest to least depending on what we are filtering it on
        Button price = view.findViewById(R.id.price);
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theOptionBundles.clear();
                theOptionBundles.addAll(searchAlgorithm.listFilteredByPrice(searchAlgorithm.getGrand(), Integer.MAX_VALUE));
                adapter.notifyDataSetChanged();
                filter="price";
            }
        });


        Button distance = view.findViewById(R.id.distance);
        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theOptionBundles.clear();
                theOptionBundles.addAll(searchAlgorithm.listFilteredByMaxDist(searchAlgorithm.getGrand(), Integer.MAX_VALUE));
                adapter.notifyDataSetChanged();
                filter="distance";
            }
        });


        Button review = view.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theOptionBundles.clear();
                theOptionBundles.addAll(searchAlgorithm.listFilteredByMinRev(searchAlgorithm.getGrand(), 0));
                adapter.notifyDataSetChanged();
                filter="review";
            }
        });

        Button local = view.findViewById(R.id.local);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theOptionBundles.clear();
                theOptionBundles.addAll(searchAlgorithm.listFilteredByLocal(searchAlgorithm.getGrand()));
                adapter.notifyDataSetChanged();
                filter="local";
            }
        });

        Button best3= view.findViewById(R.id.best3);
        best3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theOptionBundles.clear();
                theOptionBundles.addAll(searchAlgorithm.defaultBestOptions(searchAlgorithm.getGrand()));
                adapter.notifyDataSetChanged();
                filter="best";
            }
        });

        return view;
    }

    //goes back to the main screen
    public void Back(){
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_output_to_cartFragment);
    }


    //when you click a row takes you to a screen that shows all the statistics of the option bundle
    @Override
    public void showInfo(int position) {
        statistics(position);
    }

    public void statistics(int position){
        NavController navController = NavHostFragment.findNavController(this);

        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        bundle.putString("filter",filter);

        navController.navigate(R.id.action_outputToStoreStats, bundle);

    }
}