package com.example.listingandediting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employee> employeeList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Employee employee);
    }

    public EmployeeAdapter(List<Employee> employeeList, OnItemClickListener listener) {
        this.employeeList = employeeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.bind(employee, listener);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView employeeName, employeeAge, employeeDepartment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employeeName);
            employeeAge = itemView.findViewById(R.id.employeeAge);
            employeeDepartment = itemView.findViewById(R.id.employeeDepartment);
        }

        public void bind( Employee employee, OnItemClickListener listener) {
            employeeName.setText(employee.getName());
            employeeAge.setText(String.valueOf(employee.getAge()));
            employeeDepartment.setText(employee.getDepartment());

            itemView.setOnClickListener(v -> listener.onItemClick(employee));
        }
    }
}