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

import Model.WorkOff;
import RecyclerViewAdapter.WorkoffAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WorkoffFragment extends Fragment {

    private WorkoffAdapter workoffAdapter;
    List<WorkOff> workOffList;
    RecyclerView rvWorkoff;
    String myResponse;
    ImageButton btnwSortUp, btnwSortDown;
    EditText wsearch;

    String url = "http://38e7e67f1b0b.ngrok.io/workoffs";

    public WorkoffFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workoff, container, false);

        btnwSortUp = view.findViewById(R.id.btnwSortUp);
        btnwSortDown = view.findViewById(R.id.btnwSortDown);
        wsearch = view.findViewById(R.id.wsearch);

        rvWorkoff = view.findViewById(R.id.rvWorkoff);
        rvWorkoff.setHasFixedSize(true);
        rvWorkoff.setLayoutManager(new LinearLayoutManager(view.getContext()));

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
                                Type type = new TypeToken<ArrayList<WorkOff>>() {
                                }.getType();
                                workOffList = gson.fromJson(myResponse, type);
                                workoffAdapter = new WorkoffAdapter(workOffList);
                                rvWorkoff.setAdapter(workoffAdapter);
                            }
                        }
                    });
                }
            }
        });

        btnwSortUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (workOffList.size() > 0) {
                    Collections.sort(workOffList, new Comparator<WorkOff>() {
                        @Override
                        public int compare(WorkOff o1, WorkOff o2) {
                            return o1.geteId() - o2.geteId();
                        }
                    });
                }
                workoffAdapter.notifyDataSetChanged();
            }
        });

        btnwSortDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (workOffList.size() > 0) {
                    Collections.sort(workOffList, new Comparator<WorkOff>() {
                        @Override
                        public int compare(WorkOff o1, WorkOff o2) {
                            return o2.geteId() - o1.geteId();
                        }
                    });
                }
                workoffAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    /*private void initData(){
        List<WorkOff> workOffList= new ArrayList<>();

        workOffList.add(new WorkOff(20171111, "7-6-2020", "4h", "Việc riêng"));
        workOffList.add(new WorkOff(20171112, "6-6-2020", "8h", "Ốm"));
        workOffList.add(new WorkOff(20171113, "5-6-2020", "2h", "Tắc đường"));
        workOffList.add(new WorkOff(20171114, "4-6-2020", "1h", "Hỏng xe"));
        workOffList.add(new WorkOff(20171115, "3-6-2020", "30m", "Ngủ quên"));
        workOffList.add(new WorkOff(20171116, "2-6-2020", "1h", "Đi gặp khách hàng"));
        workOffList.add(new WorkOff(20171117, "1-6-2020", "8h", "Ốm"));
        workOffList.add(new WorkOff(20171118, "31-5-2020", "4h", "Việc riêng"));

        rvWorkoff.setAdapter(new WorkoffAdapter(workOffList));
    }*/
}
