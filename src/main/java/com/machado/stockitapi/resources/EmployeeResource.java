package com.machado.stockitapi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResource {

    @GetMapping("")
    public String getAllEmployees(HttpServletRequest request) {
        return "Authenticated!";
    }
}
