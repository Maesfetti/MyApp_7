package com.example.myapp4.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp4.Data.DataSources.Repository;
import com.example.myapp4.Data.Model.Item;
import com.example.myapp4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*public class ItemViewModel {
    private LiveData<List<Item>> listItems = new MutableLiveData<>();
    public ItemViewModel() {
        for (int i = 0; i < 200; i++) {
            listItems.add(new Item(R.drawable.dollar, ("Компания" + String.valueOf(i+1))));
        }
    }
    public List<Item> getlistitems(){return listItems;}

}
*/

public class ItemViewModel extends ViewModel {

    private Repository repository = new Repository();
    private final MutableLiveData<Repository> liveData = new MutableLiveData<>(new Repository());
    public LiveData<List<Item>> getListItems() {
        return repository.getListItems();
    }
    public void createList(Context context, Map<String, Integer> categories) {
        Objects.requireNonNull(liveData.getValue()).createDatabase(context, categories);
    }
    public LiveData<Repository> getLiveData() {
        return liveData;
    }


    /*private Repository repository = new Repository();
    public LiveData<List<Item>> getListItems() {
        return repository.getListItems();
    }
    public void createList(Context context, Map<String, Integer> cathegories) {
        Objects.requireNonNull(liveData.getValue()).createDatabase(context, cathegories);
    }*/
   /* public LiveData<Repositoriy> getLiveData() {
        return liveData;
    }*/



    //private MutableLiveData<List<Item>> listItems = new MutableLiveData<>();
/*
    public ItemViewModel() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            items.add(new Item(R.drawable.dollar, "Компания" + (i + 1)));
        }
        listItems.setValue(items);
    }

    public LiveData<List<Item>> getListItems() {
        return listItems;
    }*/
}