package com.machado.stockitapi.forms;

import lombok.Data;

@Data
public class UserForm extends EmployeeForm {
    private String password;
}
