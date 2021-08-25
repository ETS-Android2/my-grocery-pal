package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList.StoreStatistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ShopStatisticsAdapter extends RecyclerView.Adapter<ShopStatisticsAdapter.Viewholder>{

    private ArrayList<String> shopOptions;
    private ViewItems viewItems;
    private ReviewStores reviewStore;

    public ShopStatisticsAdapter(ArrayList<String> shopOptions, ViewItems viewItems,ReviewStores reviewStore){

        this.shopOptions=shopOptions;
        this.viewItems=viewItems;
        this.reviewStore = reviewStore;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.shop_option_row,parent,false);
        Viewholder viewholder= new Viewholder(view);




        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        String shopO= shopOptions.get(position);
        holder.title.setText(shopO);

        holder.items.setOnClickListener(new View.OnClickListener(){

            //go to the list of grocery items fragment
            @Override
            public void onClick(View v) {
                viewItems.goToItems(shopO);
            }

        });

        holder.review.setOnClickListener(new View.OnClickListener(){

            //go to the list of grocery items fragment
            @Override
            public void onClick(View v) {
                reviewStore.review(shopO);
                holder.review.setVisibility(View.INVISIBLE);
            }

        });


    }


    @Override
    public int getItemCount() {
        return shopOptions.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private Button review,items;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.SOtitle);
            review = itemView.findViewById(R.id.button);
            items = itemView.findViewById(R.id.button2);
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {

        }
    }

    public interface ViewItems {
        void goToItems(String stores);

    }

    public interface ReviewStores{
        void review(String store);
    }
}
