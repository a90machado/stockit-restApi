package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.forms.EmployeeForm;
import com.machado.stockitapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/employees")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String getAllEmployees(HttpServletRequest request) {
        return "Authenticated!";
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeForm employeeForm) {
        return ResponseEntity.ok(employeeService.createNewEmployee(employeeForm));
    }
}
