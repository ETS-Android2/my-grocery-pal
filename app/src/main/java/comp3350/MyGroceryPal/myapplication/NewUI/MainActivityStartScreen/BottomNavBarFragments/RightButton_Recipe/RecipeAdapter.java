package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.RightButton_Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Recipe;
import com.example.myapplication.R;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Viewholder>{
    private List<Recipe> recipeList;
    private GoToDescription goToDesc;

    public RecipeAdapter(List<Recipe> recipeList, GoToDescription goToDesc){
        this.recipeList = recipeList;
        this.goToDesc = goToDesc;
    }

    @NonNull
    @Override
    public RecipeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_row, parent, false);
        Viewholder viewholder = new Viewholder(view,goToDesc);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.Viewholder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.name.setText(recipe.getName());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        GoToDescription goToDescription;

        public Viewholder(@NonNull View itemView,GoToDescription goToDescription) {
            super(itemView);
            name = itemView.findViewById(R.id.nameRecipe);
            this.goToDescription=goToDescription;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            goToDesc.openDesc(getAdapterPosition());
        }
    }

    public interface GoToDescription {
        void openDesc(int position);

    }

}

