package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Credential;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.Rent;
import com.machado.stockitapi.domain.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Data
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String role;
    private String market;
    private Date startDate;
    private Date endDate;
    private List<Credential> credentials;
    private Rent rent;

    public EmployeeDTO(Employee employee) {
        this.firstName = employee.getFirstName();;
        this.lastName = employee.getLastName();
        this.employeeNumber = employee.getEmployeeNumber();
        this.role = employee.getRole();
        this.market = employee.getMarket();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
    }

    public EmployeeDTO(User user) {
        this.firstName = user.getFirstName();;
        this.lastName = user.getLastName();
        this.employeeNumber = user.getEmployeeNumber();
        this.role = user.getRole();
        this.market = user.getMarket();
        this.startDate = user.getStartDate();
        this.endDate = user.getEndDate();
    }

}
