package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;


public class NoStoresFragment extends Fragment {

    public NoStoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_no_stores, container, false);

        Button returnBtn = view.findViewById(R.id.sorryReturnButton);

        returnBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { goBack(); }
        });

        return view;
    }

    private void goBack() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_noStoresFragment_to_cartFragment);
    }
}