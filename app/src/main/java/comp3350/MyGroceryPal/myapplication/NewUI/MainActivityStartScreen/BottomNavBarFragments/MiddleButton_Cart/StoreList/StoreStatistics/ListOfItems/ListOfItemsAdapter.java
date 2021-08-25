package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList.StoreStatistics.ListOfItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import comp3350.MyGroceryPal.myapplication.NewLogic.cart;

public class ListOfItemsAdapter extends RecyclerView.Adapter<ListOfItemsAdapter.Viewholder>{


    private ArrayList<String> item;
    private ArrayList<Double> price;

    public ListOfItemsAdapter(ArrayList<String> item, ArrayList<Double> price){

        this.item = item;
        this.price=price;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.listofitemsrow,parent,false);
        Viewholder viewholder= new Viewholder(view);




        return viewholder;
    }






    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        GroceryListItems g = cart.searchItem(item.get(position));
        holder.storeText.setText(item.get(position) );
        holder.priceText.setText("$" +String.valueOf(roundOff(price.get(position)))+" x "+ g.getAmount()+" = $"+(roundOff(price.get(position)*g.getAmount())));




    }
    public double roundOff (Double n){
        return Math.round(n * 100.0) / 100.0;
    }


    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView storeText,priceText;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            storeText= itemView.findViewById(R.id.store);
            priceText = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {

        }
    }
}
