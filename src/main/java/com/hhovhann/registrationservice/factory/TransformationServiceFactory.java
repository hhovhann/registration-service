package com.hhovhann.registrationservice.factory;

import com.hhovhann.registrationservice.service.transformation.MobileTransformationService;
import com.hhovhann.registrationservice.service.transformation.TransformationService;
import com.hhovhann.registrationservice.service.transformation.WebTransformationService;
import com.hhovhann.registrationservice.types.ServiceType;
import org.springframework.stereotype.Component;

@Component
public class TransformationServiceFactory {
    public TransformationService getTransformationService(ServiceType serviceType) {
        switch (serviceType) {
            case WEB:
                return new WebTransformationService();
            case MOBILE:
                return new MobileTransformationService();
            default:
                throw new RuntimeException("No Such Service. Provide correct service type");
        }
    }
}
