package com.hhovhann.registrationservice.service.notification;

import com.hhovhann.registrationservice.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String notify(UserModel userModel) {
        // TODO notify new registered users about their registration
        return null;
    }
}
