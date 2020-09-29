package com.machado.stockitapi.services;

import com.machado.stockitapi.DTO.UserDTO;
import com.machado.stockitapi.domain.User;
import com.machado.stockitapi.exceptions.EtAuthException;
import com.machado.stockitapi.forms.LoginForm;
import com.machado.stockitapi.forms.UserForm;

public interface UserService {

    String validateUser(LoginForm loginForm) throws EtAuthException;

    UserDTO registerUser(UserForm userForm) throws EtAuthException;

}

