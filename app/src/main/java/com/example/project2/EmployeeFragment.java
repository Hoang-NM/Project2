package com.example.project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Model.Employee;
import RecyclerViewAdapter.EmployeeAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class EmployeeFragment extends Fragment {

    private EmployeeAdapter employeeAdapter, tempAdapter;
    List<Employee> employeeList, employees;
    RecyclerView rvEmployee;
    String myResponse;
    ImageButton btneSortUp, btneSortDown;
    EditText esearch;

    String url = "http://38e7e67f1b0b.ngrok.io/employees";

    public EmployeeFragment() {
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee, container, false);

        btneSortUp = view.findViewById(R.id.btneSortUp);
        btneSortDown = view.findViewById(R.id.btneSortDown);
        esearch = view.findViewById(R.id.esearch);

        rvEmployee = view.findViewById(R.id.rvEmployee);
        rvEmployee.setHasFixedSize(true);
        rvEmployee.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //parseJson();

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
                                Type type = new TypeToken<ArrayList<Employee>>() {
                                }.getType();
                                employeeList = gson.fromJson(myResponse, type);
                                employeeAdapter = new EmployeeAdapter(employeeList);
                                rvEmployee.setAdapter(employeeAdapter);
                            }
                        }
                    });
                }
            }
        });

        /*esearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = esearch.getText().toString();
                if(searchText.length() <3){
                    rvEmployee.setAdapter(employeeAdapter);
                }
                else{
                    employees = new ArrayList<>();
                    for(int i = 0; i < employeeList.size(); i++){
                        if(employees.get(i).getEName().contains(searchText) ||
                                employees.get(i).getPosition().contains(searchText))
                            employees.add(employees.get(i));
                    }
                    tempAdapter = new EmployeeAdapter(employees);
                    rvEmployee.setAdapter(tempAdapter);
                }
            }
        });*/

        btneSortUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> sortedList = new ArrayList<>();
                if (employeeList.size() > 0) {
                    Collections.sort(employeeList, new Comparator<Employee>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                            return o1.getEName().compareTo(o2.getEName());
                        }
                    });
                }
                employeeAdapter.notifyDataSetChanged();
            }
        });

        btneSortDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> sortedList = new ArrayList<>();
                if (employeeList.size() > 0) {
                    Collections.sort(employeeList, new Comparator<Employee>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                            return o2.getEName().compareTo(o1.getEName());
                        }
                    });
                }
                employeeAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    /*@Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.tool_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);

        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.v("TAG", "Searching for " + s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }*/

    /*private void parseJson(){
        String myResponse = "[{'id': 1907001, 'name': 'nguyen thi D', 'address': 'Ca Mau', 'dob': '2020-05-01', 'start': '2020-05-11', 'phone': 97877653, 'position': 'dev'}, " +
                "{'id': 1907002, 'name': 'nguyen van A', 'address': 'Cao Bang', 'dob': '1989-12-09', 'start': '2020-04-11', 'phone': 94576452, 'position': 'dev'}, " +
                "{'id': 1907003, 'name': 'nguyen van B', 'address': 'Ha Noi', 'dob': '1999-08-30', 'start': '2020-03-11', 'phone': 34764520, 'position': 'dev'}, " +
                "{'id': 1907052, 'name': 'nguyen thi C', 'address': 'Hai Duong', 'dob': '1999-06-07', 'start': '2020-05-11', 'phone': 9215468, 'position': 'dev'}, " +
                "{'id': 1907041, 'name': 'nguyen minh D', 'address': 'Hai Phong', 'dob': '1999-08-30', 'start': '2020-05-11', 'phone': 27432853, 'position': 'dev'}, " +
                "{'id': 1907101, 'name': 'nguyen minh E', 'address': 'Sa Pa', 'dob': '1999-08-30', 'start': '2020-05-11', 'phone': 45236987, 'position': 'dev'}, " +
                "{'id': 1907099, 'name': 'nguyen thi F', 'address': 'Moc Chau', 'dob': '2020-06-07', 'start': '2020-05-11', 'phone': 51353498, 'position': 'dev'}]";
        Gson gson = new Gson();
        Employee[] employeeList = gson.fromJson(myResponse, Employee[].class);
        employeeAdapter = new EmployeeAdapter(Arrays.asList(employeeList));
        rvEmployee.setAdapter(employeeAdapter);
    }*/

}
