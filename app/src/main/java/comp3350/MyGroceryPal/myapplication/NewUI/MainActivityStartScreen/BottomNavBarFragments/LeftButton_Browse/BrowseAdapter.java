package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.LeftButton_Browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.Viewholder>{
    //the list of groceryListItems we have
    private List <String> groceryListItemsTypeList;
    //responsible for handling the transtition to the list of grocery items fragment
    private GoToItems goToItems;


    public BrowseAdapter(List<String> groceryListItemsTypeList, GoToItems goToItems){

        this.groceryListItemsTypeList=groceryListItemsTypeList;
        this.goToItems=goToItems;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.groceryitemtype_row,parent,false);
        Viewholder viewholder= new Viewholder(view);




        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String type = groceryListItemsTypeList.get(position);

        holder.type.setText(type);


        holder.type.setOnClickListener(new View.OnClickListener(){

            //go to the list of grocery items fragment
            @Override
            public void onClick(View v) {
                goToItems.itemList(position);
            }

        });

    }


    @Override
    public int getItemCount() {
        return groceryListItemsTypeList.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Button type;



        public Viewholder(@NonNull View itemView) {
            super(itemView);
            type =itemView.findViewById(R.id.type);

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {

        }
    }

    public interface GoToItems {
        void itemList(int position);

    }
}
