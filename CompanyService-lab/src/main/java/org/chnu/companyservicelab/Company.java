package org.chnu.companyservicelab;

public class Company {
    Company parent;
    int employeeCount;

    public Company(Company parent, int employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public Company getParent() {
        return parent;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
}
