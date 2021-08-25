package comp3350.MyGroceryPal.myapplication.NewUI.MainActivityStartScreen.BottomNavBarFragments.MiddleButton_Cart.StoreList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import comp3350.MyGroceryPal.myapplication.NewLogic.AlgorithmForBestStores.OptionBundle;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BestStoreAdapter extends RecyclerView.Adapter<BestStoreAdapter.Viewholder> {


    private ArrayList<OptionBundle> optionBundle;
    //responsible for directing the user to the page that shows the optin bundle statistics
    private InfoButton infoButton;


    public BestStoreAdapter( ArrayList<OptionBundle> optionBundle,InfoButton infoButton){

        this.optionBundle = optionBundle;
        this.infoButton=infoButton;
    }
    @NonNull
    @Override
    public BestStoreAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.best_store_row,parent,false);
        Viewholder viewholder= new Viewholder(view,infoButton);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull BestStoreAdapter.Viewholder holder, int position) {
        OptionBundle shopOption= optionBundle.get(position);

        if(shopOption.allLocal()) {
            holder.allLocal.setText("All Local");
        } else {
            holder.allLocal.setText("Not All Local");
        }

        holder.review.setText("Review: "+String.valueOf(shopOption.getAverageReview()));
        holder.distance.setText("Distance: "+String.valueOf(shopOption.getMaxDistance()) + "km");
        holder.price.setText("Price: $"+String.valueOf(shopOption.getTotalPrice()));
        holder.numStores.setText("Number of Stores: "+String.valueOf(shopOption.getNumDistinctStores()));

    }


    @Override
    public int getItemCount() {
        return optionBundle.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView allLocal,distance,review,price, numStores;
        InfoButton infoButton;

        public Viewholder(@NonNull View itemView,InfoButton infoButton) {


            super(itemView);

            allLocal= itemView.findViewById(R.id.allLocal);
            distance=itemView.findViewById(R.id.distance);
            review = itemView.findViewById(R.id.averageReview);
            price = itemView.findViewById(R.id.totalPrice);
            numStores = itemView.findViewById(R.id.numStores);
            this.infoButton=infoButton;

            itemView.setOnClickListener(this);



        }



        @Override
        public void onClick(View v) {
            infoButton.showInfo(getAdapterPosition());
        }
    }


    public interface InfoButton{
        void showInfo(int position);
    }


}

