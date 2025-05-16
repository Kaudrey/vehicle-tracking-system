package rw.rra.tracking.vehicle.services;

import rw.rra.tracking.vehicle.dto.RegisterDTO;
import rw.rra.tracking.vehicle.enums.ERole;
import rw.rra.tracking.vehicle.models.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    RegisterDTO registerUser(RegisterDTO user, Set<ERole> role);
    String loginUser(String email, String password);
//    User getCustomerById(UUID id);
//    User getCustomerByAccount(String account);
////    CustomerDTO updateCustomer(UUID id, CustomerDTO customerDTO);
//    void deleteCustomer(UUID id);
//    List<User> getAllCustomers();
//    boolean hasRole(String role);

}
