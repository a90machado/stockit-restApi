package com.machado.stockitapi.DTO;

import com.machado.stockitapi.domain.User;
import lombok.Data;

@Data
public class UserDTO extends EmployeeDTO {

    public UserDTO(User user) {
        super(user);
    }
}
