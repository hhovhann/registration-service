package com.hhovhann.registrationservice.service.validation;

import com.hhovhann.registrationservice.model.UserModel;
import com.hhovhann.registrationservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidationServiceImpl implements ValidationService {
    private final UserRepository userRepository;

    public ValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserRegistered(UserModel userModel) {
        // request to database and check if user exist or not, for now based on mobileNumber + id. in future can have other validation
        return Objects.nonNull(userRepository.findUserByMobileNumberAndEmail(userModel.getMobileNumber(), userModel.getEmail()));
    }
}
