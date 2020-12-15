package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResource {

    @GetMapping("")
    public String getAllEmployees(HttpServletRequest request) {
        return "Authenticated!";
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        
    }
}
