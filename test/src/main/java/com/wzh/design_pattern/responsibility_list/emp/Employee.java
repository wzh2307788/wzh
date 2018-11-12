package com.wzh.design_pattern.responsibility_list.emp;

public class Employee {
    String name;
    String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Employee)){
            return false;
        }
        if(obj.hashCode()!=this.hashCode()){
            return false;
        }

      if(obj.getClass()!=Employee.class){
         return false;
        }
    return super.equals(obj);
}
}
