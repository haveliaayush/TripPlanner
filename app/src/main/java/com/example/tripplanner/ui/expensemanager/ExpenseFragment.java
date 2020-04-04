package com.example.tripplanner.ui.expensemanager;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tripplanner.R;

public class ExpenseFragment extends Fragment {

    private ExpenseViewModel expenseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        expenseViewModel = ViewModelProviders.of(this).get(ExpenseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_expense, container, false);
        final TextView textView = root.findViewById(R.id.text_expense);
        expenseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
