package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.RightButton_Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import com.example.myapplication.R;

import java.util.List;

public class RecipeIngredientsAdapter extends RecyclerView.Adapter<RecipeIngredientsAdapter.Viewholder> {

    private List<GroceryListItems> ingredients;

    public RecipeIngredientsAdapter(List<GroceryListItems> ingredients){
        this.ingredients=ingredients;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.recipe_ingredients_row,parent,false);
        Viewholder viewholder= new Viewholder(view);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        GroceryListItems groceryListItems = ingredients.get(position);
        holder.name.setText(groceryListItems.getName());
        holder.amount.setText(Integer.toString(groceryListItems.getAmount()));
    }


    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView name,amount;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);

        }
    }
}
