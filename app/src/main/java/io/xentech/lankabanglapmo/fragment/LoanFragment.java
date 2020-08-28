package io.xentech.lankabanglapmo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.xentech.lankabanglapmo.R;
import io.xentech.lankabanglapmo.activity.LoanFormActivity;
import io.xentech.lankabanglapmo.adapter.ProductListAdapter;
import io.xentech.lankabanglapmo.model.ProductListModel;

public class LoanFragment extends Fragment{

    private RecyclerView loanCatRv;
    private ProductListAdapter productListAdapter;

    private ProductListModel productListModel;

    private ArrayList<ProductListModel> productList;


    public LoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_loan, container, false);

        productList = new ArrayList<>();
        loanCatRv = view.findViewById(R.id.loan_category_list_rv);


        ProductListAdapter.ProductClickListener listener = new ProductListAdapter.ProductClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), LoanFormActivity.class);
                startActivity(intent);
            }
        };

        productListAdapter = new ProductListAdapter(productList, getContext(), listener);
        loanCatRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        loanCatRv.setAdapter(productListAdapter);


        getLoanProductsData();


        return view;
    }

    private void getLoanProductsData() {

        productListModel = new ProductListModel("Home Lone",1);
        productList.add(productListModel);

        productListModel = new ProductListModel("Auto Lone",2);
        productList.add(productListModel);

        productListModel = new ProductListModel("Business Lone",4);
        productList.add(productListModel);

        productListModel = new ProductListModel("SME Lone",6);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListModel = new ProductListModel("Holiday Lone",8);
        productList.add(productListModel);

        productListAdapter.notifyDataSetChanged();
    }

}
