package com.hhovhann.registrationservice.service.registration;

import com.hhovhann.registrationservice.model.UserModel;
import com.hhovhann.registrationservice.service.payment.PaymentAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebRegistrationService implements RegistrationService {
    @Autowired
    private PaymentAggregationService paymentAggregationService;

    @Override
    public <T> T register(T model) {
        return  paymentAggregationService.createUser((UserModel) model);
    }
}
