package com.machado.stockitapi.resources;

import com.machado.stockitapi.DTO.CredentialDTO;
import com.machado.stockitapi.DTO.EmployeeDTO;
import com.machado.stockitapi.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/credentials")
public class CredentialResource {

    @Autowired
    CredentialService credentialService;

    @PostMapping("")
    public ResponseEntity<CredentialDTO> addNewCredentialToEmployee(@RequestBody CredentialDTO credentialDTO) {
        return ResponseEntity.ok(credentialService.addNewCredential(credentialDTO));
    }

    @PostMapping("/employee")
    public ResponseEntity<List<CredentialDTO>> getCredentialsByEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(credentialService.getCredentialsByEmployee(employeeDTO));
    }

    @DeleteMapping("/credential/{id}")
    public ResponseEntity<Void> deleteCredential(@PathVariable Long id) {
        credentialService.deleteCredential(id);
        return ResponseEntity.ok().build();
    }
}
