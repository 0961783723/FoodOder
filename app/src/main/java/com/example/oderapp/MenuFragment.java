package com.example.oderapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenuFragment extends Fragment {
    RecyclerView recyclerView;
    MenuAdapter menuAdapter;

    public static MenuFragment newInstance() {  //////////////////// newi
        Bundle args = new Bundle();
        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        recyclerView = view.findViewById(R.id.rvList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        menuAdapter = new MenuAdapter(Food.foodList);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
