package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse;

import android.os.Bundle;


import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessGroceryItems;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse.GroceryItemsList.BrowseGroceryListItemsFragment;

import com.example.myapplication.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.*;


//this is a fragment where the user can browse and select items to add to their grocery cart
public class BrowseFragment extends Fragment implements BrowseAdapter.GoToItems {
    RecyclerView rView;
    BrowseAdapter adapter;
    //this is our database which represents all the items the user can add to their cart
    NewAccessGroceryItems temp;
    SearchView browseSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse, container, false);



        rView =view.findViewById(R.id.recyclerView);



        temp=new NewAccessGroceryItems();
        //adapter for the recycler view, responsible for displaying the rows in the list
        adapter= new BrowseAdapter(temp.getTypeList(),this);

        rView.setAdapter(adapter);
        rView.setLayoutManager(new GridLayoutManager(view.getContext(), 2)); // Changed from LinearLayoutManager to GridLayoutManager


        //this is for the search bar at the top
        browseSearch=view.findViewById(R.id.browse_search);
        browseSearch.clearFocus();
        browseSearch.setQueryHint("Enter Item Here");
        Fragment thisFragment = this;
        browseSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                NavController navController = NavHostFragment.findNavController(thisFragment);

                Bundle bundle = new Bundle();
                bundle.putString("word", query);


                navController.navigate(R.id.action_fragmentBrowseV2_to_storeItemFragment, bundle);




                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        return view;
    }


    @Override
    public void itemList(int position) {

        NavController navController = NavHostFragment.findNavController(this);

        Bundle bundle = new Bundle();
        bundle.putString("type", temp.getTypeList().get(position));


        navController.navigate(R.id.action_fragmentBrowseV2_to_storeItemFragment, bundle);

    }
}