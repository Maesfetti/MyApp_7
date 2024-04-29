package com.example.myapp4.View;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp4.Data.Model.FragmentNavigateData;
import com.example.myapp4.R;

public class FirstFragment extends Fragment {
    public FragmentNavigateData dataLayer = new FragmentNavigateData();
    public FirstFragment() {
        super(R.layout.fragment_first);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        view.findViewById(R.id.toListFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("listKey", dataLayer.getDatafromFirstToList());
                Navigation.findNavController(v).navigate(R.id.action_FirstFrag_to_listFragment1, bundle);
            }
        });
        view.findViewById(R.id.toRecyclerFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("recyclerKey", dataLayer.getDatafromFirstToRecycler());
                Navigation.findNavController(v).navigate(R.id.action_FirstFrag_to_recyclerFragment, bundle);
            }
        });
        return view;
    }
}