package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.searchAlgorithm;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;

import com.example.myapplication.R;

public class CartFragment extends Fragment implements CartAdapter.AddOrSubButton, CartAdapter.DeleteFunction {
    RecyclerView rView;

    CartAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        //sets up the row and layout for the recycler view (list)
        rView =view.findViewById(R.id.recyclerView);
        adapter = new CartAdapter(cart.getGroceryList(),this,rView,this);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ImageButton account = view.findViewById(R.id.account_button);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goToAccount();}
        });


        //when button is clicked go to list of stores
        Button findStores = view.findViewById(R.id.findStores);
        findStores.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                findStores();
            }
        });
        return view;
    }

    public void goToAccount() {
       NavController navController = NavHostFragment.findNavController(this);
       navController.navigate(R.id.action_cartFragment_to_accountFragment);
    }

    //calls search algorithm to find all possible combinations of stores the user can go to
    //then goes to the list of stores that list all of them
    public void findStores(){
        if (cart.getGroceryList().size() != 0) {
            searchAlgorithm.mainAlgo(cart.getGroceryList());
            NavController navController = NavHostFragment.findNavController(this);
            if (searchAlgorithm.getGrand().size() != 0) {
                navController.navigate(R.id.action_cartFragment_to_output);
            }
            else {
                navController.navigate(R.id.action_cartFragment_to_noStoresFragment);
            }
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle("You need to insert Items into your grocery list first");

            //Fragment thisFragment = this;
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            };
            alertDialogBuilder.setPositiveButton("Ok",dialogClickListener);



            AlertDialog dialog = alertDialogBuilder.create();
            dialog.show();
        }

    }

    @Override
    public void delete(int position) {
        //deletes selected item
        cart.deleteGroceryItem(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void add(int position,boolean add) {

        //adds or subtract an item from their grocery list
        if(add) {
            if (cart.getGroceryList().get(position).getAmount() < 100) {
                cart.changeAmount(position, cart.getGroceryList().get(position).getAmount() + 1);
            }
            else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("You cannot have more than 100 of this item.");

                //Fragment thisFragment = this;
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                alertDialogBuilder.setPositiveButton("Ok",dialogClickListener);



                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();
            }

        } else {
            if(cart.getGroceryList().get(position).getAmount()>1) {
                cart.changeAmount(position, cart.getGroceryList().get(position).getAmount()-1);
            }
        }
        adapter.notifyDataSetChanged();
    }
}