package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.CredentialDTO;
import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.DTO.ProductDTO;
import com.machado.stockitapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductDTO> addNewProductToEmployee(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO.getEmployeeDTO());
        return ResponseEntity.ok(productService.addNewProduct(productDTO));
    }

    @PostMapping("/employee")
    public ResponseEntity<List<ProductDTO>> getProductsByEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(productService.getProductsByEmployee(employeeDTO));
    }

}
