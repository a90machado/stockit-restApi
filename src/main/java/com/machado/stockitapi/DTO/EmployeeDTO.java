package com.machado.stockitapi.DTO;


import com.machado.stockitapi.domain.Employee;
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

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String firstName, String lastName, String employeeNumber, String role, String market, Date startDate, Date endDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.role = role;
        this.market = market;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public EmployeeDTO(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
        this.role = employee.getRole();
        this.market = employee.getMarket();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
    }

}
