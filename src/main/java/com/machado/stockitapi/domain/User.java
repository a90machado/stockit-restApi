package com.machado.stockitapi.domain;

import com.machado.stockitapi.forms.UserForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private String password;

    public User(UserForm userForm) {
        this.firstName = userForm.getFirstName();
        this.lastName = userForm.getLastName();
        this.employeeNumber = userForm.getEmployeeNumber();
        this.password = userForm.getPassword();
    }
}
