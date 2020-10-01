package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.User;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String position;
    private String localization;
    private Date startDate;
    private Date endDate;
    // private Rent rent;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();;
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
        this.position = employee.getPosition();
        this.localization = employee.getLocalization();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
    }

    public EmployeeDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();;
        this.lastName = user.getLastName();
        this.employeeNumber = user.getEmployeeNumber();
        this.position = user.getPosition();
        this.localization = user.getLocalization();
        this.startDate = user.getStartDate();
        this.endDate = user.getEndDate();
    }

}
