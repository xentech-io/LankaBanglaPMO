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
import io.xentech.lankabanglapmo.model.FileListModel;

public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.FileListHolder> {

    private ArrayList<FileListModel> fileList;
    private Context context;

    public FileListAdapter(ArrayList<FileListModel> fileList, Context context) {
        this.fileList = fileList;
        this.context = context;
    }

    @NonNull
    @Override
    public FileListHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_file_row,parent,false);

        return new FileListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileListHolder fileListHolder, int position) {

        fileListHolder.fileId.setText(String.valueOf(fileList.get(position).getFileId()));
        fileListHolder.clientName.setText(String.valueOf(fileList.get(position).getClientName()));
        fileListHolder.clientDesignation.setText(String.valueOf(fileList.get(position).getClientDesignation()));
        fileListHolder.phoneNo.setText(String.valueOf(fileList.get(position).getMobileNo()));
        fileListHolder.companyName.setText(String.valueOf(fileList.get(position).getCompanyName()));
        fileListHolder.branchName.setText(String.valueOf(fileList.get(position).getBranchName()));
        fileListHolder.productName.setText(String.valueOf(fileList.get(position).getProductName()));

    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public class FileListHolder extends RecyclerView.ViewHolder {

        TextView clientName, clientDesignation, companyName, branchName, productName, phoneNo, fileId;



        public FileListHolder(@NonNull View itemView) {
            super(itemView);

            clientName = itemView.findViewById(R.id.client_name);
            clientDesignation = itemView.findViewById(R.id.client_designation);
            companyName = itemView.findViewById(R.id.company_name);
            branchName = itemView.findViewById(R.id.branch_name);
            productName = itemView.findViewById(R.id.prduct_name);
            phoneNo = itemView.findViewById(R.id.phone_no);
            fileId = itemView.findViewById(R.id.file_id);
        }
    }
}
