package com.example.listingandediting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditEmployeeActivity extends AppCompatActivity {
    private EditText editName, editDepartment, editAge;
    private Button btnSave;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        editName = findViewById(R.id.edit_name);
        editDepartment = findViewById(R.id.edit_department);
        editAge = findViewById(R.id.edit_age);
        btnSave = findViewById(R.id.btn_save);

        employee = getIntent().getParcelableExtra("employee");

            if (employee != null) {
                editName.setText(employee.getName());
                editDepartment.setText(employee.getDepartment());
                editAge.setText(String.valueOf(employee.getAge()));
            }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String name = editName.getText().toString();
                    String department = editDepartment.getText().toString();
                    int age = Integer.parseInt(editAge.getText().toString());

                    Employee updatedEmployee = new Employee(name, department, age, employee.getId());

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("employee_id", employee.getId());
                    resultIntent.putExtra("updated_employee", updatedEmployee);

                    setResult(RESULT_OK, resultIntent);
                    finish();

            }
        });
    }
}