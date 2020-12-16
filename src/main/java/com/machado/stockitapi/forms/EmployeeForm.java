package com.machado.stockitapi.forms;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeForm {
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String role;
    private String market;
    private Date startDate;
}
