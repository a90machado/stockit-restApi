package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.UserDTO;
import com.machado.stockitapi.domain.User;
import com.machado.stockitapi.exceptions.EtAuthException;
import com.machado.stockitapi.forms.LoginForm;
import com.machado.stockitapi.forms.UserForm;
import com.machado.stockitapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String validateUser(LoginForm loginForm) throws EtAuthException {
        if (loginForm != null && loginForm.getEmployeeNumber() != null && loginForm.getPassword() != null)  {
            loginForm.setEmployeeNumber(loginForm.getEmployeeNumber().toUpperCase());
            Optional<User> optionalUser = userRepository.findByEmployeeNumber(loginForm.getEmployeeNumber());
            if(optionalUser.isPresent() && new BCryptPasswordEncoder().matches(loginForm.getPassword(), optionalUser.get().getPassword())) {
                return optionalUser.get().getFirstName() + " " + optionalUser.get().getLastName();
            } else {
                throw new EtAuthException("Invalid employee number or password.");
            }
        } else {
            throw new EtAuthException("Invalid employee number or password.");
        }
    }

    @Override
    public UserDTO registerUser(UserForm userForm) throws EtAuthException {
        if(validateUserForm(userForm)) {
            userForm.setEmployeeNumber(userForm.getEmployeeNumber().toUpperCase());
            userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
            Integer count = userRepository.countByEmployeeNumber(userForm.getEmployeeNumber());
            if (count > 0) { throw new EtAuthException("Employee already register."); }
            return new UserDTO(userRepository.save(new User(userForm)));
        } else {
            throw  new EtAuthException("Invalid details. Failed to create account.");
        }
    }


    private boolean validateUserForm(UserForm userForm) {
        // Make any extra validation
        return (userForm != null
                && userForm.getFirstName() != null
                && userForm.getLastName() != null
                && userForm.getEmployeeNumber() != null
                && userForm.getPassword() != null);
    }

}
