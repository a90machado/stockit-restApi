package com.machado.stockitapi.DTO;

import com.machado.stockitapi.enums.CredentialType;
import lombok.Data;

@Data
public class CredentialDTO {

    private Long id;
    private CredentialType type;
    private String username;
    private String password;
    private String notes;

    public CredentialDTO(Long id, CredentialType type, String username, String password, String notes) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }
}
