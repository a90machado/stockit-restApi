package com.machado.stockitapi.domain;

import com.machado.stockitapi.forms.UserForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
@Table(name="users")
public class User extends Employee {

    private String password;
    public User(UserForm userForm) {
        super(userForm);
        this.password = userForm.getPassword();
    }
}
