package com.example.myapp4.Data.DataSources;

import androidx.lifecycle.LiveData;

import com.example.myapp4.Data.Model.Item;

import java.util.List;

public interface DataSource {
    LiveData<List<Item>> getListItems();
}
