package com.hhovhann.registrationservice.service.payment;

import com.hhovhann.registrationservice.model.UserModel;

public interface PaymentAggregationService {
    <T> T createUser(UserModel userModel);
}
