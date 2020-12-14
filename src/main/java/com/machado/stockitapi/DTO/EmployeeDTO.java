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
    private String role;
    private String market;
    private Date startDate;
    private Date endDate;
    // private Rent rent;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();;
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
        this.role = employee.getRole();
        this.market = employee.getMarket();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
    }

    public EmployeeDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();;
        this.lastName = user.getLastName();
        this.employeeNumber = user.getEmployeeNumber();
        this.role = user.getRole();
        this.market = user.getMarket();
        this.startDate = user.getStartDate();
        this.endDate = user.getEndDate();
    }

}
