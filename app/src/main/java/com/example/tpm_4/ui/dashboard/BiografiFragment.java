package com.example.tpm_4.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tpm_4.R;

public class BiografiFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_biografi, container, false);
        final TextView textView = root.findViewById(R.id.tv_namaku);
        final ImageView viewImage = root.findViewById(R.id.iv_Fotoku);

        return root;
    }
}
