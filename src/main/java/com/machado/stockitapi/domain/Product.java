package com.machado.stockitapi.domain;

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
    @Column(nullable = false)
    private String serialNumber;
    @Column(nullable = true)
    private String notes;
    @Column(nullable = false)
    private boolean outOfService;
    @ManyToOne
    @JoinColumn(name="rent_id", nullable=true)
    private Rent rent;

}
