package com.machado.stockitapi.DTO;

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
    private Rent rent;

    public ProductDTO(Long id, String name, String description, String serialNumber, String notes, boolean outOfService, Rent rent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.notes = notes;
        this.outOfService = outOfService;
        this.rent = rent;
    }
}
