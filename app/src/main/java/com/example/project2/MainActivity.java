package com.example.project2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    FrameLayout fragment_container;
    ActionBar actionBar;
    Fragment homeFragment, employeeFragment, holidayFragment, workoffFragment, salaryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);

        bottomNav.setSelectedItemId(R.id.nav_home);
        homeFragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, homeFragment);
        ft.commit();

        employeeFragment = new EmployeeFragment();
        holidayFragment = new HolidayFragment();
        workoffFragment = new WorkoffFragment();
        salaryFragment = new SalaryFragment();
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Quản lý nhân viên");
        actionBar.setSubtitle("Version 1.0");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Will be available soon!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "Developed by HoangNM!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_home:
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_container, homeFragment);
                    ft.commit();
                    break;
                case R.id.nav_holiday:
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.fragment_container, holidayFragment);
                    ft1.commit();
                    break;
                case R.id.nav_employee:
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.fragment_container, employeeFragment);
                    ft2.commit();
                    break;
                case R.id.nav_workoff:
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.fragment_container, workoffFragment);
                    ft3.commit();
                    break;
                case R.id.nav_salary:
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.fragment_container, salaryFragment);
                    ft4.commit();
                    break;
            }

            return true;
        }
    };
}
