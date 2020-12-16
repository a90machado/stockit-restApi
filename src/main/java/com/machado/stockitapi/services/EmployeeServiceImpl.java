package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.forms.EmployeeForm;
import com.machado.stockitapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeForm employeeForm) throws EtBadRequestException {
        Optional<Employee> searchEmployee = this.employeeRepository.findByEmployeeNumber(employeeForm.getEmployeeNumber());
        if (searchEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee already exists.");
        } else {
            Employee newEmployee = this.employeeRepository.save(new Employee(employeeForm));
            return new EmployeeDTO(newEmployee);
        }
    }
}
