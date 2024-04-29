package com.example.myapp4.ViewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.myapp4.Data.Model.FragmentNavigateData;

public class FragmentNavigateViewModel {

    private MutableLiveData<FragmentNavigateData> data = new MutableLiveData<>();

    public FragmentNavigateViewModel(){
        data.setValue(new FragmentNavigateData());
    }
    public MutableLiveData<FragmentNavigateData> getData(){
        return data;
    }
}
