package rw.rra.tracking.vehicle.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.rra.tracking.vehicle.dto.RegisterDTO;
import rw.rra.tracking.vehicle.enums.ERole;
import rw.rra.tracking.vehicle.models.User;
import rw.rra.tracking.vehicle.repositories.UserRepo;
import rw.rra.tracking.vehicle.services.UserService;
import rw.rra.tracking.vehicle.utils.JwtTokenUtil;

import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public RegisterDTO registerUser(RegisterDTO registerDTO, Set<ERole> role) {
        if(userRepo.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setFullName(registerDTO.getFullName());
        user.setEmail(registerDTO.getEmail());
        user.setPhone(registerDTO.getPhone());
        user.setNationalId(registerDTO.getNationalId());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setCreatedAt(java.time.LocalDateTime.now());
        user.setUpdatedAt(java.time.LocalDateTime.now());
        user.setRole(role);
        userRepo.save(user);
        return registerDTO;
    }

    @Override
    public String loginUser(String email, String password ) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return jwtTokenUtil.generateToken(user);
    }
}
