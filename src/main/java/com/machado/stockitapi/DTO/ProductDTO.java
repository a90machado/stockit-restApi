package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Product;
import com.machado.stockitapi.domain.Rent;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String serialNumber;
    private String notes;
    private boolean outOfService;
    private RentDTO rent;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.serialNumber = product.getSerialNumber();
        this.notes = product.getNotes();
        this.outOfService = product.isOutOfService();
        this.rent = new RentDTO(product.getRent());
    }
}
