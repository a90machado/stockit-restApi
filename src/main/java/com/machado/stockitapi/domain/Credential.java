package com.machado.stockitapi.domain;

import com.machado.stockitapi.enums.CredentialType;
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
    private CredentialType type;
    @Column(nullable = false)
    private String username;
    @Column(nullable = true)
    private String password;
    @Column(nullable = true)
    private String notes;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

}
