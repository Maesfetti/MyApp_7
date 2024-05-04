package com.example.myapp4.View;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp4.Data.DataSources.Repository;
import com.example.myapp4.Data.Model.FragmentNavigateData;
import com.example.myapp4.R;

public class FirstFragment extends Fragment {
    private final int PERMISSION_REQUEST_CODE = 80;
    public FragmentNavigateData dataLayer = new FragmentNavigateData();
    public FirstFragment() {
        super(R.layout.fragment_first);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TextView itemName = view.findViewById(R.id.textSpecific);
        Repository repository = new Repository(this.getContext(), "file.txt", "SDFile");
        repository.writeAppSpecDS("Список компаний актуален");

        ImageView imageView = view.findViewById(R.id.image_view);
        repository.createLocalds(this.getContext());
        repository.setLocalName("Компаания");
        repository.setLocalImg(R.drawable.dollar);
        TextView textV = view.findViewById(R.id.textSH);
        textV.setText(repository.getItems().getText());
        imageView.setImageResource(repository.getItems().getImageResource());



        itemName.setText(repository.readAppSpecDS());

        TextView itemNameCom = view.findViewById(R.id.textCommon);
        view.findViewById(R.id.CommonFilesDSButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!repository.writeCommonFileDS("Список компаний актуален Common")) {
                    requestPermission();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    repository.writeCommonFileDS("Список компаний актуален Common");
                }
                String result = repository.readCommonFilesDS();
                itemNameCom.setText(result);
            }
        });
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


    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getContext(), "Требуется разрешение на запись на карту памяти!", Toast.LENGTH_LONG).show();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            Log.e("value", "Разрешение есть.");
        }
    }
}