package com.machado.stockitapi.domain;

import com.machado.stockitapi.forms.UserForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String employeeNumber;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String market;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = true)
    private Date endDate;
    @Column(nullable = true)
    @OneToMany(mappedBy = "employee")
    private List<Credential> credentials;
    @OneToOne(mappedBy = "employee")
    private Rent rent;

    public Employee(UserForm userForm) {
        this.firstName = userForm.getFirstName();
        this.lastName = userForm.getLastName();
        this.employeeNumber = userForm.getEmployeeNumber();
        this.role = userForm.getRole();
        this.market = userForm.getMarket();
        this.startDate = userForm.getStartDate();
        this.endDate = null;
    }
}
