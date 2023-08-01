package com.example.daohvph35768_lab_giaodien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.daohvph35768_lab_giaodien.Fragment.BackUp_Fragment;
import com.example.daohvph35768_lab_giaodien.Fragment.CaiDat_Fragment;
import com.example.daohvph35768_lab_giaodien.Fragment.DanhBa_Fragment;
import com.example.daohvph35768_lab_giaodien.Fragment.MayTinh_Fragment;
import com.example.daohvph35768_lab_giaodien.Fragment.ThoiTiet_Frament;
import com.example.daohvph35768_lab_giaodien.Fragment.TinTuc_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TinTuc_Fragment tinTuc_fragment;
    ThoiTiet_Frament thoiTiet_frament;
    DanhBa_Fragment danhBa_fragment;
    MayTinh_Fragment mayTinh_fragment;
    CaiDat_Fragment caiDat_fragment;
    BackUp_Fragment backUp_fragment;

    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.DrawerLayout);
        toolbar = findViewById(R.id.Toolbar);
        navigationView = findViewById(R.id.na_view);
        bottomNavigationView = findViewById(R.id.bottomNav);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Home");

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_open, R.string.app_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        drawerLayout.addDrawerListener(drawerToggle);

        tinTuc_fragment = new TinTuc_Fragment();
        thoiTiet_frament = new ThoiTiet_Frament();
        danhBa_fragment = new DanhBa_Fragment();
        mayTinh_fragment = new MayTinh_Fragment();
        caiDat_fragment = new CaiDat_Fragment();
        backUp_fragment = new BackUp_Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container, tinTuc_fragment).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.Home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, tinTuc_fragment).commit();
                } else if (item.getItemId() == R.id.DanhBa) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, danhBa_fragment).commit();
                } else if (item.getItemId() == R.id.MayTinh) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, mayTinh_fragment).commit();
                } else if (item.getItemId() == R.id.Caidat) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, caiDat_fragment).commit();
                } else if (item.getItemId() == R.id.Backup) {
                    showConfirmDialog();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Fragment_container, tinTuc_fragment)
                            .commit();
                }
                drawerLayout.close();
                return true;
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottom_tintuc) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, tinTuc_fragment).commit();
                } else if (item.getItemId() == R.id.Bottom_thoitiet) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, thoiTiet_frament).commit();
                    getSupportActionBar().setTitle(item.getTitle());
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, tinTuc_fragment).commit();
                }
                drawerLayout.close();
                return true;
            }
        });
    }

    void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Bạn có muốn Backup ko?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, backUp_fragment).commit();
            }
        });
        builder.setNegativeButton("không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //kolàm gì, tawts dialog
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}