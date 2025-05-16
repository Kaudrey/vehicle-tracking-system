package rw.rra.tracking.vehicle.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rw.rra.tracking.vehicle.models.User;
import rw.rra.tracking.vehicle.repositories.UserRepo;
import  rw.rra.tracking.vehicle.enums.ERole;

import java.util.Date;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepo userRepo,
                           PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!userRepo.existsByEmail("admin@rw.com")) {
            User admin = new User();
            admin.setFullName("System Admin");
            admin.setEmail("admin@rw.com");
            admin.setPhone("123456789");
            admin.setNationalId("12000000000000000000");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Set.of(ERole.ROLE_ADMIN));


            userRepo.save(admin);
            System.out.println("✅ Admin user created!");
        }
    }
}
