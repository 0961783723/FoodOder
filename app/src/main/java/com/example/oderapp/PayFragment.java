package com.example.oderapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PayFragment extends Fragment {
    RecyclerView recyclerView;
    Button btnSum, btnBuy;
    PayAdapter payAdapter;
    List<Food> foodList = new ArrayList<Food>();
    int sum;
    RecyclerView.LayoutManager layoutManager;

    public static PayFragment newInstance() {  //////////////////// newi
        Bundle args = new Bundle();
        PayFragment fragment = new PayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pay_fragment, container, false);

        recyclerView = view.findViewById(R.id.rvList);
        btnSum = view.findViewById(R.id.tvSum);
        btnBuy = view.findViewById(R.id.btnBuy);

        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        refreshChanged();

        calculatorMoney();


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorMoney();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food.resetCount();
                refreshChanged();
                if (sum != 0) {
                    AlertDialog dialog = new AlertDialog.Builder(getContext())
                            .setTitle("Thank You")
                            .setMessage("Your total order worth "+Integer.toString(sum)+"VND")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getContext(), Home.class);
                                    startActivity(intent);
                                }
                            })
                            .create();
                    dialog.show();
                }
            }
        });


        return view;
    }

    private void refreshChanged() {
        for (Food food : Food.foodList) {
            if (food.getCount() != 0) {
                foodList.add(food);
            }
        }
        payAdapter = new PayAdapter(foodList);
        recyclerView.setAdapter(payAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void calculatorMoney() {
        sum = 0;
        for (Food food : foodList) {
            if (food.getCount() > 0) {
                sum += food.getCount() * food.getCost();
            }
        }
        btnSum.setText("Total: " + Integer.toString(sum) + "VND");
    }


}
