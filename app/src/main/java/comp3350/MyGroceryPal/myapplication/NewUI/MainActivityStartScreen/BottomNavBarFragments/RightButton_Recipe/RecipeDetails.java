package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.RightButton_Recipe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeList;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;
import com.example.myapplication.R;

public class RecipeDetails extends Fragment {

    RecyclerView stepsRView;
    RecyclerView ingredientsRView;
    RecipeStepListAdapter adapter;
    RecipeIngredientsAdapter recipeIngredientsAdapter;
    //this represents the Recipe we want to display in our adapter
    Recipe recipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_recipe_details, container, false);
        //if the user used the search bar to find their item the bundle will contain "word"
        //if they pressed a button the bundle contains the user "name"
        Bundle bundle = this.getArguments();
        String name = bundle.getString("name");



        stepsRView = view.findViewById(R.id.steps);
        ingredientsRView = view.findViewById(R.id.ingredientsNDirections);
        //this is only not null if the user used the search bar

        AccessRecipeList temp = new AccessRecipeList();

        recipe = temp.getRecipeByName(name);

        TextView recipeName = view.findViewById(R.id.recipeName);
        TextView recipeDescription = view.findViewById(R.id.recipeDescription);
        recipeName.setText(recipe.getName());
        recipeDescription.setText(recipe.getDesc());
        if(name!=null) {

            recipe = temp.getRecipeByName(name);
        }

        if (recipe != null) {
            adapter = new RecipeStepListAdapter(recipe.getSteps());
            recipeIngredientsAdapter = new RecipeIngredientsAdapter(recipe.getIngredients());
        }

        stepsRView.setAdapter(adapter);
        stepsRView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ingredientsRView.setAdapter(recipeIngredientsAdapter);
        ingredientsRView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        Button addToCart = view.findViewById(R.id.AddToCart);
        addToCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                recipe.addIngredientsToCart();
                goToCart();
            }
        });

        Button goBack = view.findViewById(R.id.Return);
        goBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
        return view;
    }

    public void goToCart(){
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_recipeDetails_to_cartFragment);
    }

    public void goBack(){
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_recipeDetails_to_recipeFragment);
    }
}