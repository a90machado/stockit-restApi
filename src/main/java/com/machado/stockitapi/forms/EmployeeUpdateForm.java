package com.machado.stockitapi.forms;

import lombok.Data;


@Data
public class EmployeeUpdateForm extends EmployeeForm{
    private String oldEmployeeNumber;
}
