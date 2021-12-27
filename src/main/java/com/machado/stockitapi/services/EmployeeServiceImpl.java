package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
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
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException {
        Optional<Employee> searchEmployee = this.employeeRepository.findByEmployeeNumber(employeeDTO.getEmployeeNumber());
        if (searchEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee already exists.");
        } else {
            Employee newEmployee = this.employeeRepository.save(new Employee(employeeDTO));
            return new EmployeeDTO(newEmployee);
        }
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException {
        Optional<Employee> updateEmployee = this.employeeRepository.findById(employeeDTO.getId());
        if (!updateEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        } else {
            if (updateEmployee.get().getEmployeeNumber() != employeeDTO.getEmployeeNumber()) {
                Optional<Employee> checkIfEmployeeNumber = this.employeeRepository.findByEmployeeNumber(employeeDTO.getEmployeeNumber());
                if (checkIfEmployeeNumber.isPresent()) {
                    throw  new EtBadRequestException("Employee number cannot be assigned to this employee.");
                }
            }
            Employee saveEmployee = this.employeeRepository.save(new Employee(employeeDTO));
            return new EmployeeDTO(saveEmployee);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> searchEmployee = this.employeeRepository.findById(id);
        if (!searchEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        }
        return new EmployeeDTO(employeeRepository.getOne(id));
    }

}
