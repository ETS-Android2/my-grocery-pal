package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.Account;



import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.NewAccessAccount;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.User;
import comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.MainActivity;




public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        NewAccessAccount newAccessAccount = new NewAccessAccount();

        final EditText username=(EditText)view.findViewById(R.id.loginUsername);
        final EditText password=(EditText)view.findViewById(R.id.loginPassword);
        final Button login=(Button)view.findViewById(R.id.loginButton);
        final TextView registerLink=(TextView) view.findViewById(R.id.registerLink);
        final TextView link2=(TextView)view.findViewById(R.id.returnFromLogin);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User a = new User(username.getText().toString(), password.getText().toString());
                if(a.validUserNameAndPassword(false)) {
                    if (newAccessAccount.authenticate(a)) {
                        MainActivity.signIn = true;
                        //not an error message, just confirmation it worked
                        errorMessage("You have successfully logged in");
                        returnFromLogin();
                    } else {
                        errorMessage("User Name or Password does not exist");
                    }
                } else {
                    errorMessage("User Name and Password must be between 4-15 characters");
                }
            }
        });
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnFromLogin();
            }
        });

        return view;
    }

    public void errorMessage(String error){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getView().getContext());
        alertDialogBuilder.setTitle(error);

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        break;
                }
            }
        };

        alertDialogBuilder.setPositiveButton("OK",dialogClickListener);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();
    }



    // Go to the Register fragment
    private void goToRegister() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_loginFragment_to_registerFragment);
    }
    // Go to the Account fragment
    private void returnFromLogin() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_loginFragment_to_accountFragment);
    }

}
