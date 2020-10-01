package com.machado.stockitapi.repositories;

import com.machado.stockitapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    Integer countByEmployeeNumber(String employeeNumber);
    Optional<User> findByEmployeeNumber(String employeeNumber);
}
