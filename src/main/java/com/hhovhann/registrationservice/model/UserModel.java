package com.hhovhann.registrationservice.model;

import com.hhovhann.registrationservice.types.ServiceType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    String fullName;
    String role;
    String email;
    String mobileNumber;
    ServiceType serviceType;
    String userName;
    String password;
}
