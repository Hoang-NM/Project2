package RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

import java.util.List;

import Model.Holiday;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    List<Holiday> holidayList;

    public HolidayAdapter(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtHName;
        TextView txtHDate;
        TextView txtInfor;

        MyViewHolder(View view) {
            super(view);

            txtHName = view.findViewById(R.id.txtHName);
            txtHDate = view.findViewById(R.id.txtHDate);
            txtInfor = view.findViewById(R.id.txtInfor);
        }
    }

    @Override
    public HolidayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_holiday, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtHName.setText(holidayList.get(position).getHName());
        holder.txtHDate.setText(holidayList.get(position).getDate());
        holder.txtInfor.setText(holidayList.get(position).getInfor());
    }

    @Override
    public int getItemCount() {
        return holidayList.size();
    }
}
