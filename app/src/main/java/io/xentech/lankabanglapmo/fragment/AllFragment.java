package io.xentech.lankabanglapmo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.xentech.lankabanglapmo.R;
import io.xentech.lankabanglapmo.activity.FileListActivity;
import io.xentech.lankabanglapmo.adapter.DataAdapter;
import io.xentech.lankabanglapmo.model.DataModel;

public class AllFragment extends Fragment {

    private RecyclerView dataRv;
    private DataAdapter dataAdapter;

    private DataModel dataModel;

    private ArrayList<DataModel> dataList;

   // private RequestQueue mRequestQueue;


    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_all, container, false);

        dataList = new ArrayList<>();
        dataRv = view.findViewById(R.id.all_data_rv);


        DataAdapter.RecyclerViewClickListener listener = new DataAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(getActivity(), FileListActivity.class);
                startActivity(intent);

            }
        };


      //  mRequestQueue = Volley.newRequestQueue(getActivity());

        dataAdapter = new DataAdapter(dataList, getContext(), listener);
        dataRv.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));
        dataRv.setAdapter(dataAdapter);



        getData();

        return view;
    }

    private void getData() {

        dataModel = new DataModel("Query", 100);
        dataList.add(dataModel);

        dataModel = new DataModel("Approved", 50);
        dataList.add(dataModel);

        dataModel = new DataModel("Declined", 5);
        dataList.add(dataModel);

        dataModel = new DataModel("Pending", 30);
        dataList.add(dataModel);

        dataAdapter.notifyDataSetChanged();



    }

}
