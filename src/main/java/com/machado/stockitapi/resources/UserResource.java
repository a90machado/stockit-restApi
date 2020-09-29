package com.machado.stockitapi.resources;

import com.machado.stockitapi.forms.LoginForm;
import com.machado.stockitapi.forms.UserForm;
import com.machado.stockitapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginForm loginForm) {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Login successfully.");
        map.put("welcome", userService.validateUser(loginForm));
        return ResponseEntity.ok(map);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserForm userForm) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Registered successfully.");
        map.put("userCreated", userService.registerUser(userForm));
        return ResponseEntity.ok(map);
    }
}
