package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse.GroceryItemsList;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessGroceryItems;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;

import com.example.myapplication.R;

import java.util.ArrayList;


public class BrowseGroceryListItemsFragment extends Fragment implements BrowseGroceryListItemsAdapter.AddAmount {

    RecyclerView rView;
    BrowseGroceryListItemsAdapter adapter;
    NewAccessGroceryItems newAccessGroceryItems;
    //this represents the list we want to display in our adapter
    ArrayList<GroceryListItems> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_store_list, container, false);


        //if the user used the search bar to find their item the bundle will contain "word"
        //if they pressed a button the bundle contains the user "type"

        Bundle bundle = this.getArguments();
        String type = bundle.getString("type");
        rView = view.findViewById(R.id.rView);
        //this is only not null if the user used the search bar

        newAccessGroceryItems= new NewAccessGroceryItems();

        if(type!=null) {
            list= (ArrayList<GroceryListItems>) newAccessGroceryItems.getGroceryListItemsByType(type);
        } else {
            list = (ArrayList<GroceryListItems>) newAccessGroceryItems.getGroceryItemListByName(bundle.getString("word"));

        }


        if (list != null) {
            adapter = new BrowseGroceryListItemsAdapter(
                    list, this);
        } else {
            System.out.println("Browse Grocery List Items Adapter is null");
        }

        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        AppCompatButton returnBtn = view.findViewById(R.id.storeListReturnButton);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goBack(); }
        });

        return view;
    }

    // Return to previous fragment
    private void goBack() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_storeItemFragment_to_fragmentBrowseV2);
    }

    //this is the dialog that pops up and ask the user the amount of items they want to buy
    @Override
    public void addAmount(int position) {

        final EditText input = new EditText(getContext());
        input.setId(0);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle("Select Amount");

        alertDialogBuilder.setView(input);

        //Fragment thisFragment = this;
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        try {
                            if (Integer.parseInt(input.getText().toString()) <= 0) {
                                cantAddItem("You cannot have an amount of zero");
                            } else if (Integer.parseInt(input.getText().toString()) > 100) {

                                cantAddItem("You can only add a maximum of 100 items");
                            } else if (!(input.getText().toString().equals(""))) {
                                //adds the item to the grocery list
                                GroceryListItems adding = list.get(position);
                                GroceryListItems copy = new GroceryListItems(adding.getName(), Integer.parseInt(input.getText().toString()), adding.getType());
                                if(!cart.addGroceryItem(copy)){
                                    cantAddItem("Adding this much will make you exceed the limit of 100");
                                }


                            }
                        } catch(NumberFormatException e){
                            cantAddItem("You can only add a maximum of 100 items");
                        }
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //does nothing. Meant for if the user changes their mind and do not want the item anymore
                        break;

                }
            }
        };
        alertDialogBuilder.setPositiveButton("Add",dialogClickListener);
        alertDialogBuilder.setNegativeButton("Back",dialogClickListener);


        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();



    }

    private void cantAddItem(String message){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle(message);


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