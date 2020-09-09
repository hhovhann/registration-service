package com.hhovhann.registrationservice.factory;

import com.hhovhann.registrationservice.service.registration.RegistrationService;
import com.hhovhann.registrationservice.service.registration.MobileRegistrationService;
import com.hhovhann.registrationservice.service.registration.WebRegistrationService;
import com.hhovhann.registrationservice.types.ServiceType;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceFactory {
    public RegistrationService getRegistrationService(ServiceType serviceType) {
        switch (serviceType) {
            case WEB:
                return new WebRegistrationService();
            case MOBILE:
                return new MobileRegistrationService();
            default:
                throw new RuntimeException("No Such Service. Provide correct service type");
        }
    }
}
