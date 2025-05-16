package rw.rra.tracking.vehicle.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rw.rra.tracking.vehicle.models.User;
import rw.rra.tracking.vehicle.repositories.UserRepo;
import rw.rra.tracking.vehicle.security.UserPrincipal;

import java.util.UUID;

@Service
public class UsersDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public UsersDetailsService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(UUID id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + id)
        );

        return UserPrincipal.create(user);
    }
}

