package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.exceptions.EtResourceNotFoundException;
import com.machado.stockitapi.forms.EmployeeForm;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    EmployeeDTO createNewEmployee(EmployeeForm employeeForm) throws EtBadRequestException;
}

