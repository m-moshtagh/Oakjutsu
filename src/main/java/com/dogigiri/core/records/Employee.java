package com.dogigiri.core.records;

public record Employee(long employeeId, String employeeName, String empCode) {
    static final int UUID = 79787878;
    // modifying the Constructor
    public Employee{ // this is called compact constructors
        employeeName = "(fullname) " + employeeName;
    }

    public Employee(){
        this(0, null, null);
    }
    public void getSalary() {
        System.out.println("No salary");
    }
}
