package com.example.tripplanner.ui.flight;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
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


public class FlightFragment extends Fragment {

    private FlightViewModel flightViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        flightViewModel = ViewModelProviders.of(this).get(FlightViewModel.class);
        View root = inflater.inflate(R.layout.fragment_flight, container, false);
        final TextView textView = root.findViewById(R.id.text_flight);
        flightViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
