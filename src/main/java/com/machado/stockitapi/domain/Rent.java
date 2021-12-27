package com.machado.stockitapi.domain;

import com.machado.stockitapi.DTO.RentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    @OneToMany(mappedBy="rent")
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    public Rent(RentDTO rentDTO) {
        this.id = rentDTO.getId();
        List<Product> products = new ArrayList<>();
        rentDTO.getProducts().forEach(p -> {
            products.add(new Product(p));
        });
        this.products = products;
        this.employee = new Employee(rentDTO.getEmployee());
    }

}
