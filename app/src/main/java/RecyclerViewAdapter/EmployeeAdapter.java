package RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;

import java.util.List;

import Model.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtEId;
        TextView txtEName;
        TextView txtPosition;
        TextView txtPhone;

        MyViewHolder(View view) {
            super(view);

            txtEId = view.findViewById(R.id.txtEId);
            txtEName = view.findViewById(R.id.txtEName);
            txtPosition = view.findViewById(R.id.txtPosition);
            txtPhone = view.findViewById(R.id.txtPhone);
        }
    }

    @Override
    public EmployeeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_employee, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtEId.setText(employeeList.get(position).getEId() + "");
        holder.txtEName.setText(employeeList.get(position).getEName());
        holder.txtPosition.setText(employeeList.get(position).getPosition());
        holder.txtPhone.setText(employeeList.get(position).getPhone() + "");
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

}
