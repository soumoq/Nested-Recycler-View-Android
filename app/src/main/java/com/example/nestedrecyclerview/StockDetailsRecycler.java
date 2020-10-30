package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StockDetailsRecycler extends RecyclerView.Adapter<StockDetailsRecycler.ViewHolder> {

    private ArrayList<String> mData;

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    // data is passed into the constructor
    public StockDetailsRecycler(Context context, ArrayList<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_stock_details, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        //Toast.makeText(holder.itemName.getContext(), active.get(position), Toast.LENGTH_LONG).show();
        holder.itemName.setText(mData.get(position));

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;
        RelativeLayout allStock;
        TextView currentStock;
        ImageView add, div;
        ProgressBar progressBar;


        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemView.setOnClickListener(this);
            allStock = itemView.findViewById(R.id.all_stock);
            currentStock = itemView.findViewById(R.id.current_stock);
            add = itemView.findViewById(R.id.add);
            div = itemView.findViewById(R.id.div);
            progressBar = itemView.findViewById(R.id.progress_ber);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    /*private void selectQuantity(View view, String currentStock, String vId, String uId, String flag, TextView cStock) {

        Context context = view.getContext();
        SelectQuantityDialog popUpOtpVerification = new SelectQuantityDialog(currentStock, vId, uId, flag, cStock);
        popUpOtpVerification.show(((FragmentActivity) context).getSupportFragmentManager(), "PopUpOtpVerification");



    }*/
}
