package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.Credential;
import lombok.Data;

@Data
public class CredentialDTO {

    private Long id;
    private String type;
    private String username;
    private String password;
    private String notes;
    private EmployeeDTO employeeDTO;

    public CredentialDTO(Credential credential) {
        this.id = credential.getId();
        this.type = credential.getType();
        this.username = credential.getUsername();
        this.password = credential.getPassword();
        this.notes = credential.getNotes();
        this.employeeDTO = new EmployeeDTO(credential.getEmployee());
    }

    public CredentialDTO(Long id, String type, String username, String password, String notes, EmployeeDTO employeeDTO) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
        this.notes = notes;
        this.employeeDTO = employeeDTO;
    }
}
