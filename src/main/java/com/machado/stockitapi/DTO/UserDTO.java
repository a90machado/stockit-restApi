package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.User;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.employeeNumber = user.getEmployeeNumber();
    }
}
