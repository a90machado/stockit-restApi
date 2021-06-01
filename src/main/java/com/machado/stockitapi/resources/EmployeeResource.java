package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.forms.EmployeeForm;
import com.machado.stockitapi.forms.EmployeeUpdateForm;
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

    @GetMapping("")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{employeeNumber}")
    public ResponseEntity<EmployeeDTO> getEmployeeByNumber(@PathVariable String employeeNumber) {
        return ResponseEntity.ok(employeeService.getEmployeeByNumber(employeeNumber));
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeForm employeeForm) {
        return ResponseEntity.ok(employeeService.createNewEmployee(employeeForm));
    }

    @PutMapping("")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeUpdateForm employeeForm) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeForm));
    }
}
