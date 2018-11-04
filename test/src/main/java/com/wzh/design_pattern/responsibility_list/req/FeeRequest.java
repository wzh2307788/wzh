package com.wzh.design_pattern.responsibility_list.req;

import com.wzh.design_pattern.responsibility_list.emp.Employee;

public class FeeRequest extends Request {
    Employee employee;
    double fee;

    public FeeRequest(Employee employee, double fee) {
        this.employee = employee;
        this.fee = fee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


}
