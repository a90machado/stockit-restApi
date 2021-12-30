package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.CredentialDTO;
import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.DTO.ProductDTO;
import com.machado.stockitapi.domain.Credential;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.Product;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.repositories.CredentialRepository;
import com.machado.stockitapi.repositories.EmployeeRepository;
import com.machado.stockitapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService  {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<ProductDTO> getProductsByEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException {
        Optional<Employee> updateEmployee = this.employeeRepository.findById(employeeDTO.getId());
        if (!updateEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        } else {
            List<Product> products = this.productRepository.getProductsByEmployee(new Employee(employeeDTO));

            List<ProductDTO> productsToReturn = new ArrayList<>();
            products.forEach(p -> {
                productsToReturn.add(new ProductDTO(p));
            });
            return productsToReturn;
        }
    }

    @Override
    public ProductDTO addNewProduct(ProductDTO productDTO) throws EtBadRequestException {
        Optional<Employee> updateEmployee = this.employeeRepository.findById(productDTO.getEmployeeDTO().getId());
        if (!updateEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        } else {
            return new ProductDTO(productRepository.save(new Product(productDTO)));
        }
    }
}
