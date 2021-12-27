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
    @JoinColumn(name="rent_id", nullable=true)
    private Rent rent;

    public Product(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.description = productDTO.getDescription();
        this.serialNumber = productDTO.getSerialNumber();
        this.notes = productDTO.getNotes();
        this.outOfService = productDTO.isOutOfService();
        this.rent = new Rent(productDTO.getRent());
    }

}
