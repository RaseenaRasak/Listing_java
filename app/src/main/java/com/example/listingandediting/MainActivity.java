package com.example.listingandediting;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int EDIT_REQUEST_CODE = 1;
    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter;
    private List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Raseena", "Developer", 23, 1));
        employeeList.add(new Employee("Prithvi", "Developer", 23, 2));
        employeeList.add(new Employee("Anagha", "Marketing", 23, 3));
        employeeList.add(new Employee("Megha", "Developer", 30, 4));
        employeeList.add(new Employee("Aarya", "Business", 32, 5));

        employeeAdapter = new EmployeeAdapter(employeeList, new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Employee employee) {
                Intent intent = new Intent(MainActivity.this, EditEmployeeActivity.class);
                intent.putExtra("employee", employee);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });
        recyclerView.setAdapter(employeeAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Employee updatedEmployee = data.getParcelableExtra("updated_employee");

            if (updatedEmployee != null) {
                for (int i = 0; i < employeeList.size(); i++) {
                    if (employeeList.get(i).getId() == updatedEmployee.getId()) {
                        employeeList.set(i, updatedEmployee);
                        employeeAdapter.notifyItemChanged(i);
                        break;
                    }
                }
            }
        }
    }
}