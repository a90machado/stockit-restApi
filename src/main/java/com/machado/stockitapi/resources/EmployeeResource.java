package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/employees")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeByNumber(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.createNewEmployee(employeeDTO));
    }

    @PutMapping("")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO));
    }
}
