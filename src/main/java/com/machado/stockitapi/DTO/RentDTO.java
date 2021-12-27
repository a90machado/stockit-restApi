package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.Product;
import com.machado.stockitapi.domain.Rent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RentDTO {
    private Long id;
    private List<ProductDTO> products;
    private EmployeeDTO employee;

    public RentDTO(Rent rent){
        this.id = rent.getId();
        List<ProductDTO> productDTOS = new ArrayList<>();
        rent.getProducts().forEach(p -> {
            productDTOS.add(new ProductDTO(p));
        });
        this.products = productDTOS;
        this.employee = new EmployeeDTO(rent.getEmployee());
    }
}
