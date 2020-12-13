package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.Product;
import lombok.Data;

import java.util.List;

@Data
public class RentDTO {
    private Long id;
    private List<Product> products;
    private Employee employee;

    public RentDTO(Long id, List<Product> products, Employee employee) {
        this.id = id;
        this.products = products;
        this.employee = employee;
    }
}
