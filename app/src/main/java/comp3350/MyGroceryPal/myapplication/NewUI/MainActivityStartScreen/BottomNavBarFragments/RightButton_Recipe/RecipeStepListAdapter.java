package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.RightButton_Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;


public class RecipeStepListAdapter extends RecyclerView.Adapter<RecipeStepListAdapter.Viewholder>{
    //the method responsible for adding ingredients to cart
    private List<String> recipeSteps;


    public RecipeStepListAdapter(List<String> steps){
        this.recipeSteps=steps;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.recipe_step_row,parent,false);
        Viewholder viewholder= new Viewholder(view);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String step = recipeSteps.get(position);
        holder.step.setText(step);
    }

    @Override
    public int getItemCount() {
        return recipeSteps.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        private TextView step;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            step =itemView.findViewById(R.id.step);
        }
    }
}
