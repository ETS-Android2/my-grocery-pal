package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.RightButton_Recipe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.MyGroceryPal.myapplication.NewData.DataBases.AccessRecipeList;
import com.example.myapplication.R;

public class RecipeFragment extends Fragment implements RecipeAdapter.GoToDescription{

    private RecipeAdapter adapter;
    private RecyclerView rView;
    AccessRecipeList temp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_recipe, container, false);
        temp=new AccessRecipeList();
        rView = view.findViewById(R.id.recipeRView);

        adapter = new RecipeAdapter(temp.getRecipeList(), this);

        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;

    }

    @Override
    public void openDesc(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("name",temp.getRecipeList().get(position).getName());
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_recipeFragment_to_recipeDetails,bundle);




    }
}