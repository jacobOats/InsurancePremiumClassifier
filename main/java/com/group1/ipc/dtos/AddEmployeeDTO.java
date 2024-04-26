package com.group1.ipc.dtos;

import com.group1.ipc.entities.Employee;
import com.group1.ipc.entities.Organization;

public class AddEmployeeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private Employee manager;

    private String email;

    private String password;

    private Organization organization;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public Employee getManager() {
        return manager;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
