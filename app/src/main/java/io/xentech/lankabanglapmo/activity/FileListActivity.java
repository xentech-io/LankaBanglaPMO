package io.xentech.lankabanglapmo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.xentech.lankabanglapmo.R;
import io.xentech.lankabanglapmo.adapter.DataAdapter;
import io.xentech.lankabanglapmo.adapter.FileListAdapter;
import io.xentech.lankabanglapmo.model.DataModel;
import io.xentech.lankabanglapmo.model.FileListModel;

public class FileListActivity extends AppCompatActivity {

    private RecyclerView fileListRv;
    private FileListAdapter fileListAdapter;

    private FileListModel fileListModel;

    private ArrayList<FileListModel> fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_files);

        fileList = new ArrayList<>();

        fileListRv = findViewById(R.id.file_list_rv);


        //  mRequestQueue = Volley.newRequestQueue(getActivity());

        fileListAdapter = new FileListAdapter(fileList, this);
        fileListRv.setLayoutManager(new LinearLayoutManager(this));
        fileListRv.setAdapter(fileListAdapter);


        getFileList();
    }

    private void getFileList() {

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListModel = new FileListModel("Abdul Majid", "Managing Director", "Abdul Ltd.", "Banani", "Credit Card", "01682165208","1234567890123456");
        fileList.add(fileListModel);

        fileListAdapter.notifyDataSetChanged();
    }
}
