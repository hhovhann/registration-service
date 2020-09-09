package com.hhovhann.registrationservice.service.validation;

import com.hhovhann.registrationservice.model.UserModel;

public interface ValidationService {
    boolean isUserRegistered(UserModel mobileNumber);
}
