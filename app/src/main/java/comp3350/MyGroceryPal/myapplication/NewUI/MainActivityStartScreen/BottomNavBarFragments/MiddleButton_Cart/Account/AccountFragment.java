package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.Account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;

import com.example.myapplication.R;

public class AccountFragment extends Fragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Button returnBtn = view.findViewById(R.id.returnFromAccount);
        Button accountInfoBtn = view.findViewById(R.id.accountInfoBtn);
        Button personalInfoBtn = view.findViewById(R.id.personalInfoBtn);
        Button addressInfoBtn = view.findViewById(R.id.addressInfoBtn);
        Button loginBtn = view.findViewById(R.id.loginBtn);
        Button logoutBtn = view.findViewById(R.id.logoutBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.signIn = false;
                goBack();

            }
        });

        if (MainActivity.signIn) {
            loginBtn.setVisibility(view.GONE);
        }
        else { // User is NOT signed in
            accountInfoBtn.setVisibility(view.GONE);
            personalInfoBtn.setVisibility(view.GONE);
            addressInfoBtn.setVisibility(view.GONE);
            logoutBtn.setVisibility(view.GONE);
        }


        returnBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { goBack(); }
        });


        return view;
    }

    // Returns to the previous fragment
    private void goBack() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_accountFragment_to_cartFragment);
    }

    // Go to the Login fragment
    private void goToLogin() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_accountFragment_to_loginFragment);
    }

}