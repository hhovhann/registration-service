package com.hhovhann.registrationservice.service.transformation;

import com.hhovhann.registrationservice.model.UserModel;
import org.springframework.stereotype.Component;

 public class MobileTransformationService implements TransformationService {
    @Override
    public <T> UserModel transformToUser(T model) {
        // TODO Transform from text message get details and build User Model
        return (UserModel) model;
    }
}
