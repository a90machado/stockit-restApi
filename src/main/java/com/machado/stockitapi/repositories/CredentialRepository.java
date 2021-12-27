package com.machado.stockitapi.repositories;

import com.machado.stockitapi.domain.Credential;
import com.machado.stockitapi.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    List<Credential> getCredentialsByEmployee(Employee employee);
}
