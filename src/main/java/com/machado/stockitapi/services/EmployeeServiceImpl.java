package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.forms.EmployeeForm;
import com.machado.stockitapi.forms.EmployeeUpdateForm;
import com.machado.stockitapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee e : employees) {
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return employeeDTOS;
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

    @Override
    public EmployeeDTO getEmployeeByNumber(String employeeNumber) {
        Optional<Employee> searchEmployee = this.employeeRepository.findByEmployeeNumber(employeeNumber);
        if (searchEmployee.isPresent()) {
            return new EmployeeDTO(searchEmployee.get());

        } else {
            throw  new EtBadRequestException("Employee not found.");
        }
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeUpdateForm employeeForm) {
        Optional<Employee> searchEmployee = this.employeeRepository.findByEmployeeNumber(employeeForm.getOldEmployeeNumber());
        if (searchEmployee.isPresent()) {
            Employee employee = searchEmployee.get();
            if (!employee.getEmployeeNumber().equals(employeeForm.getEmployeeNumber())){
                employee.setEmployeeNumber(employeeForm.getEmployeeNumber());
            }
            if (!employee.getFirstName().equals(employeeForm.getFirstName())){
                employee.setFirstName(employeeForm.getFirstName());
            }
            if (!employee.getLastName().equals(employeeForm.getLastName())){
                employee.setLastName(employeeForm.getLastName());
            }
            if (!employee.getStartDate().equals(employeeForm.getStartDate())){
                employee.setStartDate(employeeForm.getStartDate());
            }
            if (!employee.getRole().equals(employeeForm.getRole())){
                employee.setRole(employeeForm.getRole());
            }
            if (!employee.getMarket().equals(employeeForm.getMarket())){
                employee.setMarket(employeeForm.getMarket());
            }
            return new EmployeeDTO(this.employeeRepository.save(employee));

        } else {
            throw  new EtBadRequestException("Employee not found, cannot be updated.");
        }
    }
}
