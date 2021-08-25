package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse.GroceryItemsList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

;
import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import com.example.myapplication.R;

import java.util.List;

public class BrowseGroceryListItemsAdapter extends RecyclerView.Adapter<BrowseGroceryListItemsAdapter.Viewholder> {

    private List<GroceryListItems> storeItemList;
    //the method responsible for changing the amount
    AddAmount addAmount;


    public BrowseGroceryListItemsAdapter(List<GroceryListItems> storeItemList, AddAmount addAmount){

        this.storeItemList=storeItemList;
        this.addAmount = addAmount;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.store_item_row,parent,false);
        BrowseGroceryListItemsAdapter.Viewholder viewholder= new BrowseGroceryListItemsAdapter.Viewholder(view, addAmount);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull BrowseGroceryListItemsAdapter.Viewholder holder, int position) {
        GroceryListItems storeItems = storeItemList.get(position);
        holder.name.setText(storeItems.getName());
    }


    @Override
    public int getItemCount() {
        return storeItemList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;

        AddAmount addAmount;


        public Viewholder(@NonNull View itemView, AddAmount addAmount) {

            super(itemView);
            name =itemView.findViewById(R.id.title);
            this.addAmount = addAmount;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {

            addAmount.addAmount(getAdapterPosition());
        }
    }

    public interface AddAmount {
        void addAmount(int position);
    }

}
