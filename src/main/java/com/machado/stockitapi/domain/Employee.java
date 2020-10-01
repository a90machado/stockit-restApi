package com.machado.stockitapi.domain;

import com.machado.stockitapi.forms.UserForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String position;
    private String localization;
    private Date startDate;
    private Date endDate;
    //private Rent rent;

    public Employee(UserForm userForm) {
        this.firstName = userForm.getFirstName();
        this.lastName = userForm.getLastName();
        this.employeeNumber = userForm.getEmployeeNumber();
        this.position = userForm.getPosition();
        this.localization = userForm.getLocalization();
        this.startDate = userForm.getStartDate();
        this.endDate = null;
    }
}
