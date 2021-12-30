package com.machado.stockitapi.domain;

import com.machado.stockitapi.DTO.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = true)
    private String serialNumber;
    @Column(nullable = true)
    private String notes;
    @Column(nullable = false)
    private boolean outOfService;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    public Product(Long id, String name, String description, String serialNumber, String notes, boolean outOfService, Employee employee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.notes = notes;
        this.outOfService = outOfService;
        this.employee = employee;
    }

    public Product(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.serialNumber = productDTO.getSerialNumber();
        this.notes = productDTO.getNotes();
        this.outOfService = productDTO.isOutOfService();
        this.employee = new Employee(productDTO.getEmployeeDTO());
    }

}
