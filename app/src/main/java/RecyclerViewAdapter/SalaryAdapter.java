package RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

import java.util.List;

import Model.Salary;

public class SalaryAdapter extends RecyclerView.Adapter<SalaryAdapter.MyViewHolder> {

    List<Salary> salaryList;

    public SalaryAdapter(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtsEId;
        TextView txtSDate;
        TextView txtNote;
        TextView txtTotal;

        MyViewHolder(View view) {
            super(view);

            txtsEId = view.findViewById(R.id.txtsEId);
            txtSDate = view.findViewById(R.id.txtSDate);
            txtNote = view.findViewById(R.id.txtNote);
            txtTotal = view.findViewById(R.id.txtTotal);
        }
    }

    @Override
    public SalaryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_salary, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtsEId.setText(salaryList.get(position).geteId() + "");
        holder.txtSDate.setText(salaryList.get(position).getsDate());
        holder.txtNote.setText(salaryList.get(position).getNote());
        holder.txtTotal.setText(salaryList.get(position).getTotal() + "");
    }

    @Override
    public int getItemCount() {
        return salaryList.size();
    }

}
