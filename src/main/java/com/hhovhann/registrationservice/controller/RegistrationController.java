package com.hhovhann.registrationservice.controller;

import com.hhovhann.registrationservice.factory.RegistrationServiceFactory;
import com.hhovhann.registrationservice.factory.TransformationServiceFactory;
import com.hhovhann.registrationservice.model.UserModel;
import com.hhovhann.registrationservice.service.notification.NotificationService;
import com.hhovhann.registrationservice.service.registration.RegistrationService;
import com.hhovhann.registrationservice.service.transformation.TransformationService;
import com.hhovhann.registrationservice.service.validation.ValidationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class RegistrationController {

    private final RegistrationServiceFactory registrationServiceFactory;
    private final TransformationServiceFactory transformationServiceFactory;
    private final ValidationService validationService;
    private final NotificationService notificationService;

    public RegistrationController(RegistrationServiceFactory registrationServiceFactory, TransformationServiceFactory transformationServiceFactory, ValidationService validationService, NotificationService notificationService) {
        this.registrationServiceFactory = registrationServiceFactory;
        this.transformationServiceFactory = transformationServiceFactory;
        this.validationService = validationService;
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/register/", consumes = MediaType.APPLICATION_JSON_VALUE)
    <T> ResponseEntity<T> registerUser(@RequestBody T model) {
        // 1. Get proper transformation implementation
        TransformationService transformationService = transformationServiceFactory.getTransformationService(userModel.getServiceType());
        // 2. Transform to User Model
        UserModel userModel = transformationService.transformToUser(model);
        // 2. Check user exist or no to not do other logic and waste server side time
        boolean userRegistered = validationService.isUserRegistered(userModel);
        if (!userRegistered) {
            // 3. Get proper registration implementation
            RegistrationService registrationService = registrationServiceFactory.getRegistrationService(userModel.getServiceType());
            // 4. Register User to the system
            registrationService.register(userModel);
            // 5. Notify that was ok or not the all registration process
            notificationService.notify(userModel);
            // 6. return The notification result as a response
            return ResponseEntity.of(null);
        }
        // TODO should change to proper results
        return ResponseEntity.of(null);
    }
}
