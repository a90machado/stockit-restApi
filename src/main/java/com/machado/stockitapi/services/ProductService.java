package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.DTO.ProductDTO;
import com.machado.stockitapi.exceptions.EtBadRequestException;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException;
    ProductDTO addNewProduct(ProductDTO productDTO)  throws EtBadRequestException;
}
