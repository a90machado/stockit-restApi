package com.machado.stockitapi.domain;

import com.machado.stockitapi.DTO.EmployeeDTO;
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
    private String jobTitle;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String officeLocation;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = true)
    private Date endDate;
    @Column(nullable = true)
    @OneToMany(mappedBy = "employee")
    private List<Credential> credentials;
    @Column(nullable = true)
    @OneToMany(mappedBy = "employee")
    private List<Product> products;

    public Employee(Long id, String firstName, String lastName, String employeeNumber, String jobTitle, String department, String officeLocation, String phoneNumber, String email, Date startDate, Date endDate, List<Credential> credentials, List<Product> products) {
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
        this.credentials = credentials;
        this.products = products;
    }

    public Employee(EmployeeDTO employeeDTO) {
        this.id = employeeDTO.getId();
        this.firstName = employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.employeeNumber = employeeDTO.getEmployeeNumber();
        this.jobTitle = employeeDTO.getJobTitle();
        this.department = employeeDTO.getDepartment();
        this.officeLocation = employeeDTO.getOfficeLocation();
        this.phoneNumber = employeeDTO.getPhoneNumber();
        this.email = employeeDTO.getEmail();
        this.startDate = employeeDTO.getStartDate();
        this.endDate = employeeDTO.getEndDate();
    }

}
