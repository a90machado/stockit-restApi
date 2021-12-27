package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.CredentialDTO;
import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.exceptions.EtBadRequestException;

import java.util.List;

public interface CredentialService {
    CredentialDTO addNewCredential(CredentialDTO credentialDTO) throws EtBadRequestException;
    List<CredentialDTO> getCredentialsByEmployee(EmployeeDTO employeeDTO) throws EtBadRequestException;
    void deleteCredential(Long id) throws EtBadRequestException;
}
