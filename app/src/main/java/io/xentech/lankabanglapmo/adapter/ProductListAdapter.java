package io.xentech.lankabanglapmo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.xentech.lankabanglapmo.R;
import io.xentech.lankabanglapmo.model.ProductListModel;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductHolder>{

    public interface ProductClickListener {
        void onClick(View view, int position);
    }

    private ArrayList<ProductListModel> productList;
    private Context context;

    private ProductClickListener productClickListener;

    public ProductListAdapter(ArrayList<ProductListModel> productList, Context context, ProductClickListener productClickListener) {
        this.productList = productList;
        this.context = context;
        this.productClickListener = productClickListener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_product_row, viewGroup, false);

        return new ProductHolder(view ,productClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int i) {

        productHolder.productName.setText(productList.get(i).getProductName());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;

        public ProductHolder(@NonNull View itemView, ProductClickListener listener) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            productClickListener.onClick(view, getAdapterPosition());

        }
    }


}
