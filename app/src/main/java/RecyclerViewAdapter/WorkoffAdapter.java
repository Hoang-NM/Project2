package RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

import java.util.List;

import Model.WorkOff;

public class WorkoffAdapter extends RecyclerView.Adapter<WorkoffAdapter.MyViewHolder> {

    List<WorkOff> workOffList;

    public WorkoffAdapter(List<WorkOff> workOffList) {
        this.workOffList = workOffList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtwEId;
        TextView txtDayoff;
        TextView txtTimeoff;
        TextView txtReason;

        MyViewHolder(View view) {
            super(view);

            txtwEId = view.findViewById(R.id.txtwEId);
            txtDayoff = view.findViewById(R.id.txtDayoff);
            txtTimeoff = view.findViewById(R.id.txtTimeoff);
            txtReason = view.findViewById(R.id.txtReason);
        }
    }

    @Override
    public WorkoffAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_workoff, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkoffAdapter.MyViewHolder holder, int position) {

        holder.txtwEId.setText(workOffList.get(position).geteId() + "");
        holder.txtDayoff.setText(workOffList.get(position).getDayOff());
        holder.txtTimeoff.setText(workOffList.get(position).getTimeOff());
        holder.txtReason.setText(workOffList.get(position).getReason());
    }

    @Override
    public int getItemCount() {
        return workOffList.size();
    }
}
