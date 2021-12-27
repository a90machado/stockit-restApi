package com.machado.stockitapi.domain;

import com.machado.stockitapi.DTO.CredentialDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="credentials")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String username;
    @Column(nullable = true)
    private String password;
    @Column(nullable = true)
    private String notes;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    public Credential(CredentialDTO credentialDTO) {
        this.id = credentialDTO.getId();
        this.type = credentialDTO.getType();
        this.username = credentialDTO.getUsername();
        this.password = credentialDTO.getPassword();
        this.notes = credentialDTO.getNotes();
        this.employee = new Employee(credentialDTO.getEmployeeDTO());
    }

    public Credential(Long id, String type, String username, String password, String notes, Employee employee) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
        this.notes = notes;
        this.employee = employee;
    }
}
