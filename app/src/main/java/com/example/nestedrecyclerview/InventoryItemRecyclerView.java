package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.*;


public class InventoryItemRecyclerView extends RecyclerView.Adapter<InventoryItemRecyclerView.ViewHolder> {


    private ArrayList<String> productName;
    private String proId;

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private StockDetailsRecycler stockDetailsRecycler;


    // data is passed into the constructor
    public InventoryItemRecyclerView(Context context, ArrayList<String> productName) {
        this.mInflater = LayoutInflater.from(context);
        this.productName = productName;
        this.proId = proId;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_inventory_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.itemName.setText(productName.get(position));
        //getProduct(proId, holder.progressBar, holder);

        ArrayList<String> name = new ArrayList<>();
        name.add("Ganguly");

        if (position % 2 == 0) {
            stockDetailsRecycler = new StockDetailsRecycler(holder.itemDetails.getContext(), name);
            holder.itemDetails.setAdapter(stockDetailsRecycler);
        }


    }

    // total number of cells
    @Override
    public int getItemCount() {
        return productName.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;
        RecyclerView itemDetails;
        ToggleButton showItem;
        ProgressBar progressBar;
        ListView listView;

        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemDetails = itemView.findViewById(R.id.item_details);
            showItem = itemView.findViewById(R.id.show_list);
            progressBar = itemView.findViewById(R.id.progress_ber);
            listView = itemView.findViewById(R.id.list_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
