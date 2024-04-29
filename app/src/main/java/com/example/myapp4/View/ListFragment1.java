package com.example.myapp4.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapp4.ViewModel.ItemViewModel;
import com.example.myapp4.View.Adapter.ListAdapter;
import com.example.myapp4.R;

public class ListFragment1 extends Fragment {
    public ListFragment1() {
        super(R.layout.fragment_list1);
    }
    public ItemViewModel listItems = new ItemViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list1, container, false);

        ListView listView = view.findViewById(R.id.listView);

        ListAdapter adapter = new ListAdapter(getContext(), R.layout.list_item, listItems.getListItems().getValue());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Item " + (position + 1), Toast.LENGTH_SHORT).show();
                Log.d("ListView", "Item " + (position + 1));
            }
        });
        view.findViewById(R.id.returnFromList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_list_to_first);
            }
        });
        assert getArguments() != null;
        String result = getArguments().getString("listKey");
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        return view;
    }
}