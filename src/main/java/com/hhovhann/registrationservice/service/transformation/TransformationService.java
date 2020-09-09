package com.hhovhann.registrationservice.service.transformation;

import com.hhovhann.registrationservice.model.UserModel;
import org.springframework.stereotype.Component;

public interface TransformationService {
    <T> UserModel transformToUser(T model);
}
