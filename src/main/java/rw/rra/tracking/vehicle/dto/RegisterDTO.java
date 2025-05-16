package rw.rra.tracking.vehicle.dto;

import rw.rra.tracking.vehicle.enums.ERole;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterDTO{
    String fullName;
    String email;
    String phone;
    String nationalId;
    String password;
}
