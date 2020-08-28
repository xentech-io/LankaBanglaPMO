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
import io.xentech.lankabanglapmo.model.DataModel;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private ArrayList<DataModel> dataList;
    private Context context;

    private  RecyclerViewClickListener mListener;

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }


    public DataAdapter(ArrayList<DataModel> dataList, Context context, RecyclerViewClickListener mListener) {
        this.dataList = dataList;
        this.context = context;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_data_grid,parent,false);

        return new DataHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder dataHolder, int position) {

        dataHolder.dataNumber.setText(String.valueOf(dataList.get(position).getDataNumber()));
        dataHolder.dataType.setText(dataList.get(position).getDataType());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView dataNumber, dataType;
        public DataHolder(@NonNull View itemView,  RecyclerViewClickListener listener) {
            super(itemView);

            dataNumber = itemView.findViewById(R.id.data_number);
            dataType = itemView.findViewById(R.id.data_type);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(mListener != null){

                mListener.onClick(view,getAdapterPosition());

            }
        }
    }
}
