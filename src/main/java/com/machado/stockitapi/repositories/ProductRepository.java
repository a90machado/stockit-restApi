package com.machado.stockitapi.repositories;

import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByEmployee(Employee employee);
}
