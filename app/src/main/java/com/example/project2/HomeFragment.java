package com.example.project2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.example.project2.R;

import java.util.ArrayList;
import java.util.List;

import Model.Holiday;


public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        AnyChartView holidayChart = view.findViewById(R.id.holiday_chart);

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> holidayList = new ArrayList<>();
        holidayList.add(new ValueDataEntry("Jan", 10));
        holidayList.add(new ValueDataEntry("Feb", 2));
        holidayList.add(new ValueDataEntry("Mar", 1));
        holidayList.add(new ValueDataEntry("Apr", 2));
        holidayList.add(new ValueDataEntry("May", 1));
        holidayList.add(new ValueDataEntry("Jun", 5));
        holidayList.add(new ValueDataEntry("Jul", 0));

        Column column = cartesian.column(holidayList);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(0d)
                .format("{%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("Holiday Column Chart");

        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Month");
        cartesian.yAxis(0).title("Day-offs");

        holidayChart.setChart(cartesian);

        return view;
    }
}
