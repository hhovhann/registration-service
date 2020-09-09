package com.hhovhann.registrationservice.service.transformation;

import com.hhovhann.registrationservice.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
 public class WebTransformationService implements TransformationService {
    @Override
    public <T> UserModel transformToUser(T model) {
        return (UserModel) model;
    }
}
