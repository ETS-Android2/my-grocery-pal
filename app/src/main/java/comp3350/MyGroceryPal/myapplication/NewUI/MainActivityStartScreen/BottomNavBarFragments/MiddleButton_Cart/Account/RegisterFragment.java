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


public class RegisterFragment extends Fragment {

    EditText username;
    EditText password;
    EditText name;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        NewAccessAccount newAccessAccount = new NewAccessAccount();

        username=(EditText)view.findViewById(R.id.registerUsername);
        password=(EditText)view.findViewById(R.id.registerPassword);
        name=(EditText)view.findViewById(R.id.registerName);
        final Button register=(Button) view.findViewById(R.id.registerButton);
        final TextView logIn=(TextView) view.findViewById(R.id.logLink);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User a = new User(username.getText().toString(), password.getText().toString(), name.getText().toString());
                if(a.validUserNameAndPassword(true)) {
                    if (!newAccessAccount.usernameExists(a)) {
                        newAccessAccount.add(a);
                        successfulRegister();
                    } else {
                        errorMessage("Username already exists");
                    }
                } else {
                    errorMessage("Invalid input. All inputs must be between 4-15 characters");
                }
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
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

    public void successfulRegister(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getView().getContext());
        alertDialogBuilder.setTitle("Registering Account Successful");

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        goToLogin();
                        break;
                }
            }
        };

        alertDialogBuilder.setPositiveButton("OK",dialogClickListener);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();
    }



    // Go to the Login fragment
    private void goToLogin() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_registerFragment_to_loginFragment);
    }

}
