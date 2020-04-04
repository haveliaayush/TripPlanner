package com.example.tripplanner.ui.hotel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tripplanner.R;

public class HotelFragment extends Fragment {

    private HotelViewModel hotelViewModel;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        hotelViewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hotel, container, false);
        final TextView textView = root.findViewById(R.id.text_hotel);
        hotelViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
