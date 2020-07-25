package com.example.project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Model.Salary;
import RecyclerViewAdapter.SalaryAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SalaryFragment extends Fragment {

    private SalaryAdapter salaryAdapter;
    List<Salary> salaryList;
    RecyclerView rvSalary;
    String myResponse;
    ImageButton btnsSortUp, btnsSortDown;
    EditText ssearch;

    String url = "http://38e7e67f1b0b.ngrok.io/salaries";

    public SalaryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salary, container, false);

        btnsSortUp = view.findViewById(R.id.btnsSortUp);
        btnsSortDown = view.findViewById(R.id.btnsSortDown);
        ssearch = view.findViewById(R.id.ssearch);

        rvSalary = (RecyclerView) view.findViewById(R.id.rvSalary);
        rvSalary.setHasFixedSize(true);
        rvSalary.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //initData();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (myResponse != null) {
                                Gson gson = new Gson();
                                Type type = new TypeToken<ArrayList<Salary>>() {
                                }.getType();
                                salaryList = gson.fromJson(myResponse, type);
                                salaryAdapter = new SalaryAdapter(salaryList);
                                rvSalary.setAdapter(salaryAdapter);
                            }
                        }
                    });
                }
            }
        });

        btnsSortUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (salaryList.size() > 0) {
                    Collections.sort(salaryList, new Comparator<Salary>() {
                        @Override
                        public int compare(Salary o1, Salary o2) {
                            return o1.getTotal() - o2.getTotal();
                        }
                    });
                }
                salaryAdapter.notifyDataSetChanged();
            }
        });

        btnsSortDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (salaryList.size() > 0) {
                    Collections.sort(salaryList, new Comparator<Salary>() {
                        @Override
                        public int compare(Salary o1, Salary o2) {
                            return o2.getTotal() - o1.getTotal();
                        }
                    });
                }
                salaryAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    /*private void initData(){
        List<Salary> salaryArrayList = new ArrayList<>();

        salaryArrayList.add(new Salary(20173134,"1-6-2020", "oke", "500$"));
        salaryArrayList.add(new Salary(20173135, "1-6-2020", "oke", "600$"));
        salaryArrayList.add(new Salary(20173136, "1-6-2020", "oke", "700$"));
        salaryArrayList.add(new Salary(20173137, "1-6-2020", "oke", "800$"));
        salaryArrayList.add(new Salary(20173138, "1-6-2020", "oke", "900$"));
        salaryArrayList.add(new Salary(20173139, "1-6-2020", "oke", "1000$"));
        salaryArrayList.add(new Salary(20173130, "1-6-2020", "oke", "1100$"));
        salaryArrayList.add(new Salary(20173131, "1-6-2020", "oke", "1200$"));

        rvSalary.setAdapter(new SalaryAdapter(salaryArrayList));
    }*/
}
