package rw.rra.tracking.vehicle.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rra.tracking.vehicle.dto.LoginDTO;
import rw.rra.tracking.vehicle.dto.RegisterDTO;
import rw.rra.tracking.vehicle.enums.ERole;
import rw.rra.tracking.vehicle.services.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final UserService userService;

    AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        try{
            Set<ERole> role = new HashSet<>();
            role.add(ERole.ROLE_STANDARD); //Default role

            RegisterDTO registered = userService.registerUser(registerDTO, role);
            return ResponseEntity.ok(registered);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {

        String token = userService.loginUser(loginDTO.getEmail(), loginDTO.getPassword());
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);

    }

}

