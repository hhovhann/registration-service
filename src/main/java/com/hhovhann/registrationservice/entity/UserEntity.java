package com.hhovhann.registrationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// This should be the user which will be stored in the database system depends on type
// we should provide proper configuration in application.properties.
public class UserEntity {
    String fullName;
    String userName;
    String mobileNumber;
    String email;
    String role;
}
