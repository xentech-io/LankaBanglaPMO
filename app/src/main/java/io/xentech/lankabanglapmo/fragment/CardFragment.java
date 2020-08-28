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
import io.xentech.lankabanglapmo.activity.CardFormActivity;
import io.xentech.lankabanglapmo.activity.LoanFormActivity;
import io.xentech.lankabanglapmo.adapter.ProductListAdapter;
import io.xentech.lankabanglapmo.model.ProductListModel;

public class CardFragment extends Fragment {

    private RecyclerView cardCatRv;
    private ProductListAdapter productListAdapter;

    private ProductListModel productListModel;

    private ArrayList<ProductListModel> productList;


    public CardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        productList = new ArrayList<>();
        cardCatRv = view.findViewById(R.id.card_category_list_rv);


        ProductListAdapter.ProductClickListener listener = new ProductListAdapter.ProductClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), CardFormActivity.class);
                startActivity(intent);

            }
        };




        productListAdapter = new ProductListAdapter(productList, getContext(), listener);
        cardCatRv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        cardCatRv.setAdapter(productListAdapter);



        getCardProductsData();


        return view;
    }

    private void getCardProductsData() {

        productListModel = new ProductListModel("Visa Card",1);
        productList.add(productListModel);

        productListModel = new ProductListModel("Master Card",2);
        productList.add(productListModel);

        productListModel = new ProductListModel("American Express",4);
        productList.add(productListModel);

        productListModel = new ProductListModel("Visa Bundle",6);
        productList.add(productListModel);

        productListModel = new ProductListModel("Master Card Bundle",8);
        productList.add(productListModel);

        productListAdapter.notifyDataSetChanged();
    }

}
