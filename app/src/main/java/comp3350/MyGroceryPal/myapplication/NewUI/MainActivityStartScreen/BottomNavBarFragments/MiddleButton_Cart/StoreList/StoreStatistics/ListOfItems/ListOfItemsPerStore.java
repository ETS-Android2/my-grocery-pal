package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList.StoreStatistics.ListOfItems;

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
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class ListOfItemsPerStore extends Fragment {

    ListOfItemsAdapter listOfItemsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_of_items_per_store, container, false);

        Bundle bundle = this.getArguments();
        ArrayList<String> items = bundle.getStringArrayList("items");
        ArrayList<Double> price = (ArrayList<Double>) bundle.getSerializable("price");


        RecyclerView rView = view.findViewById(R.id.rView);
        listOfItemsAdapter = new ListOfItemsAdapter(items,price);
        rView.setAdapter(listOfItemsAdapter);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                goBack();
            }
        });

        TextView store = view.findViewById(R.id.textView6);
        store.setText(getArguments().getString("stores"));
        return view;
    }

    public void goBack(){
        Bundle bundle = new Bundle();

        bundle.putInt("position",getArguments().getInt("position"));
        bundle.putString("filter", getArguments().getString("filter"));
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_listOfItemsPerStore_to_storeStatistics, bundle);
    }
}