package rw.rra.tracking.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rra.tracking.vehicle.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(UUID id);
//    void getAllUsers();
    Optional<User> getUserById(UUID id);
    //    Customer findByAccountNumber(String accountNumber);
    boolean existsByEmail(String email);
    boolean existsById(UUID id);

    UUID id(UUID id);
}
