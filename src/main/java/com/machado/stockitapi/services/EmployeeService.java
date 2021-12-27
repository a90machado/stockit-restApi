package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.exceptions.EtBadRequestException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException;
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException;
    EmployeeDTO getEmployeeById(Long id);

}

