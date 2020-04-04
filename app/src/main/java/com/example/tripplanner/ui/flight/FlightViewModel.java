package com.example.tripplanner.ui.flight;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FlightViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FlightViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is flight fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
