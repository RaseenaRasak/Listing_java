package com.example.listingandediting;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Employee implements Parcelable {
    private String name;
    private int age;
    private String department;
    private int id;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Employee(String name, String department, int age, int id) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.id = id;
    }

    protected Employee(Parcel in) {
        name = in.readString();
        age = in.readInt();
        department = in.readString();
        id = in.readInt();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(department);
        dest.writeInt(id);
    }
}
