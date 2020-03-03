package com.example.tpm_4.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpm_4.AdapterPahlawan;
import com.example.tpm_4.DataPahlawan;
import com.example.tpm_4.DetailActivity;
import com.example.tpm_4.ModelPahlawan;
import com.example.tpm_4.R;

import java.util.ArrayList;

public class PahlawanFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> listPahlawan = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pahlawan, container, false);
        rvPahlawan = root.findViewById(R.id.rvPahlawan);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(DataPahlawan.getListData());
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        final AdapterPahlawan adapterPahlawan = new AdapterPahlawan(getContext());
        adapterPahlawan.setListPahlawan(listPahlawan);
        rvPahlawan.setAdapter(adapterPahlawan);

        adapterPahlawan.setOnItemClickCallback(new AdapterPahlawan.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelPahlawan pahlawan) {
                Toast.makeText(getContext(), "Memilih "+pahlawan.getHeroName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA,pahlawan);
                startActivity(intent);
            }
        });
    }
}
