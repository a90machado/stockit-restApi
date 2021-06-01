package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.exceptions.EtResourceNotFoundException;
import com.machado.stockitapi.forms.EmployeeForm;
import com.machado.stockitapi.forms.EmployeeUpdateForm;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO createNewEmployee(EmployeeForm employeeForm) throws EtBadRequestException;
    EmployeeDTO getEmployeeByNumber(String employeeNumber);
    EmployeeDTO updateEmployee(EmployeeUpdateForm employeeForm);
}

