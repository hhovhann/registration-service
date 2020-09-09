package com.hhovhann.registrationservice.service.registration;

import com.hhovhann.registrationservice.model.UserModel;

public interface RegistrationService {
    <T> T register(T model);
}
