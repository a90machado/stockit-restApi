package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.exceptions.EtResourceNotFoundException;
import com.machado.stockitapi.forms.EmployeeForm;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    EmployeeDTO getEmployeeByEmployeeNumber(String employeeNumber) throws EtResourceNotFoundException;
    EmployeeDTO addEmployee(EmployeeForm employeeForm) throws EtBadRequestException;
    EmployeeDTO updateEmployee(EmployeeForm employeeForm) throws EtBadRequestException;
    EmployeeDTO deactivateEmployee(EmployeeForm employeeForm) throws EtResourceNotFoundException;
}

