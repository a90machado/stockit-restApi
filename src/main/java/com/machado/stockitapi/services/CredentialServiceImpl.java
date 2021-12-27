package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.CredentialDTO;
import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.domain.Credential;
import com.machado.stockitapi.domain.Employee;
import com.machado.stockitapi.exceptions.EtBadRequestException;
import com.machado.stockitapi.repositories.CredentialRepository;
import com.machado.stockitapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService  {

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public CredentialDTO addNewCredential(CredentialDTO credentialDTO) throws EtBadRequestException {
        Optional<Employee> updateEmployee = this.employeeRepository.findById(credentialDTO.getEmployeeDTO().getId());
        if (!updateEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        } else {
            return new CredentialDTO(credentialRepository.save(new Credential(credentialDTO)));
        }
    }

    @Override
    public List<CredentialDTO> getCredentialsByEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException {
        Optional<Employee> updateEmployee = this.employeeRepository.findById(employeeDTO.getId());
        if (!updateEmployee.isPresent()) {
            throw  new EtBadRequestException("Employee not found.");
        } else {
            List<Credential> credentials = this.credentialRepository.getCredentialsByEmployee(new Employee(employeeDTO));
            List<CredentialDTO> credentialToReturn = new ArrayList<>();
            credentials.forEach(c -> {
                credentialToReturn.add(new CredentialDTO(c));
            });
            return credentialToReturn;
        }
    }

    @Override
    public void deleteCredential(Long id) throws EtBadRequestException {
        Optional<Credential> credential = credentialRepository.findById(id);
        if (!credential.isPresent()) {
            throw  new EtBadRequestException("Credential not found.");
        } else {
            credentialRepository.delete(credential.get());
        }
    }
}
