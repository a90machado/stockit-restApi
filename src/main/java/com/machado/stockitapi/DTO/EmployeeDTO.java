package com.machado.stockitapi.DTO;


import com.machado.stockitapi.domain.Employee;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String jobTitle;
    private String department;
    private String officeLocation;
    private String phoneNumber;
    private String email;
    private Date startDate;
    private Date endDate;

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String firstName, String lastName, String employeeNumber, String jobTitle, String department, String officeLocation, String phoneNumber, String email, Date startDate, Date endDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.jobTitle = jobTitle;
        this.department = department;
        this.officeLocation = officeLocation;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EmployeeDTO(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
        this.jobTitle = employee.getJobTitle();
        this.department = employee.getDepartment();
        this.officeLocation = employee.getOfficeLocation();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
    }

}
