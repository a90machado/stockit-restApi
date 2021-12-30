package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Product;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private String notes;
    private boolean outOfService;
    private EmployeeDTO employeeDTO;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.serialNumber = product.getSerialNumber();
        this.notes = product.getNotes();
        this.outOfService = product.isOutOfService();
        this.employeeDTO = new EmployeeDTO(product.getEmployee());
    }

    public ProductDTO(Long id, String name, String description, String serialNumber, String notes, boolean outOfService, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.notes = notes;
        this.outOfService = outOfService;
        this.employeeDTO = employeeDTO;
    }
}
