package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.MyGroceryPal.myapplication.NewData.DataClasses.Items.Subclasses.GroceryListItems;
import com.example.myapplication.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {

    private DeleteFunction mDeleteFunction;
    private List<GroceryListItems> groceryList;
    private AddOrSubButton addRsub;
    private DeleteFunction deleteFunction;

    public CartAdapter(List<GroceryListItems> groceryList, DeleteFunction deleteFunction, RecyclerView rView, AddOrSubButton addRsub){

        this.groceryList=groceryList;
        this.mDeleteFunction = deleteFunction;
        this.addRsub = addRsub;
        this.deleteFunction=deleteFunction;
    }
    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.cart_row,parent,false);
        Viewholder viewholder= new Viewholder(view);




        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        GroceryListItems items = groceryList.get(position);


        holder.name.setText(items.getName());
        holder.itemQuantity.setText(String.valueOf(items.getAmount()));



        holder.add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addRsub.add(position,true);
            }
        });

        holder.sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addRsub.add(position,false);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteFunction.delete(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return groceryList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView itemQuantity,name;
        private Button add,sub,delete;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.item_name);
            itemQuantity=itemView.findViewById(R.id.itemAmount);
            add=itemView.findViewById(R.id.plus_button);

            sub=itemView.findViewById(R.id.minus_button);
            delete=itemView.findViewById(R.id.X_button);



            itemView.setOnClickListener(this);



        }



        @Override
        public void onClick(View v) {

        }
    }

    public interface DeleteFunction {
        void delete(int position);

    }

   public interface AddOrSubButton {
        void add(int position,boolean add);
    }
}
