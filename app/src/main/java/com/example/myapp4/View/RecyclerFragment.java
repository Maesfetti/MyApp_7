package com.example.myapp4.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapp4.ViewModel.ItemViewModel;
import com.example.myapp4.R;
import com.example.myapp4.View.Adapter.RecycleAdapter;

public class RecyclerFragment extends Fragment {
    public RecyclerFragment() {
        super(R.layout.fragment_recycler);
    }
    public ItemViewModel listItems = new ItemViewModel();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems.getListItems().getValue());

        /*listItems = new ItemViewModel(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()));


        //RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems.getListItems().getValue());
        RecycleAdapter adapter = new RecycleAdapter(getContext(), listItems.getListItems().getValue().observe(getViewLifecycleOwner(), items -> {
            adapter.notifyDataSetChanged();
        });*/

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.returnFromRecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_recycler_to_first);
            }
        });
        assert getArguments() != null;
        String result = getArguments().getString("recyclerKey");
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        return view;
    }
}