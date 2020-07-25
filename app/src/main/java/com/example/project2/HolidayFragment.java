package com.example.project2;

import android.content.Context;
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

import Model.Holiday;
import RecyclerViewAdapter.HolidayAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HolidayFragment extends Fragment {

    private HolidayAdapter holidayAdapter;
    List<Holiday> holidayList;
    RecyclerView rvHoliday;
    String myResponse;
    ImageButton btnhSortUp, btnhSortDown;
    EditText hsearch;

    String url = "http://38e7e67f1b0b.ngrok.io/holidays";

    public HolidayFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_holiday, container, false);

        btnhSortUp = view.findViewById(R.id.btnhSortUp);
        btnhSortDown = view.findViewById(R.id.btnhSortDown);
        hsearch = view.findViewById(R.id.hsearch);

        rvHoliday = (RecyclerView) view.findViewById(R.id.rvHoliday);
        rvHoliday.setHasFixedSize(true);
        rvHoliday.setLayoutManager(new LinearLayoutManager(view.getContext()));

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
                                Type type = new TypeToken<ArrayList<Holiday>>() {
                                }.getType();
                                holidayList = gson.fromJson(myResponse, type);
                                holidayAdapter = new HolidayAdapter(holidayList);
                                rvHoliday.setAdapter(holidayAdapter);
                            }
                        }
                    });
                }
            }
        });


        btnhSortUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holidayList.size() > 0) {
                    Collections.sort(holidayList, new Comparator<Holiday>() {
                        @Override
                        public int compare(Holiday o1, Holiday o2) {
                            return o1.getDate().compareTo(o2.getDate());
                        }
                    });
                }
                holidayAdapter.notifyDataSetChanged();
            }
        });

        btnhSortDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holidayList.size() > 0) {
                    Collections.sort(holidayList, new Comparator<Holiday>() {
                        @Override
                        public int compare(Holiday o1, Holiday o2) {
                            return o2.getDate().compareTo(o1.getDate());
                        }
                    });
                }
                holidayAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    /*private void initData(){
        List<Holiday> holidayArrayList = new ArrayList<>();

        holidayArrayList.add(new Holiday("Tết Dương Lịch","1-1","Nghỉ tết dương lịch"));
        holidayArrayList.add(new Holiday("Tết nguyên đán","23-1 đến 29-1 ","Nghỉ tết nguyên đán từ 29 đến mùng 5 âm lịch"));
        holidayArrayList.add(new Holiday("Giỗ tổ Hùng Vương","2-4","Nghỉ ngày giỗ tổ Hùng Vương 10-3 âm lịch"));
        holidayArrayList.add(new Holiday("Giải phóng miền Nam","30-4","Nghỉ ngày giải phóng miền Nam 30-4"));
        holidayArrayList.add(new Holiday("Quốc tế lao động","1-5","Nghỉ ngày quốc tế lao động 1-5"));
        holidayArrayList.add(new Holiday("Quốc khánh","2-9","Nghỉ ngày quốc khánh 2-9"));

        rvHoliday.setAdapter(new HolidayAdapter(holidayArrayList));
    }*/
}
