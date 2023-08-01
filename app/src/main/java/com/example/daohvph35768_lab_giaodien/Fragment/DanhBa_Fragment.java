package com.example.daohvph35768_lab_giaodien.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daohvph35768_lab_giaodien.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DanhBa_Fragment extends Fragment {
    FloatingActionButton fabb;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_danhba, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabb = view.findViewById(R.id.fabb);
        context = view.getContext();

        fabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd();
            }
        });
    }

    void DialogAdd(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater =getLayoutInflater();
        View view = inflater.inflate(R.layout.themdialog,null);
        builder.setView(view);

        AlertDialog dialog = builder.create();

        dialog.show();
    }
}