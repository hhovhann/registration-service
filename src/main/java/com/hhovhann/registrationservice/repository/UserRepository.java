package com.hhovhann.registrationservice.repository;

import com.hhovhann.registrationservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    <T> T findUserByMobileNumberAndEmail(String mobileNumber, String email);
}
