package com.hhovhann.registrationservice.service.payment;

import com.hhovhann.registrationservice.model.UserModel;
import com.lipisha.sdk.LipishaClient;
import com.lipisha.sdk.api.LipishaAPI;
import com.lipisha.sdk.response.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public class LipishaPaymentAggregationService implements PaymentAggregationService {
    @Value("${lipisha.api.key}")
    public static String apiKey;
    @Value("${lipisha.api.signature}")
    public static String apiSignature;
    @Value("${lipisha.api.version}")
    public static String apiVersion;
    @Value("${lipisha.api.type}")
    public static String apiType;
    @Value("${lipisha.account.number}")
    public static String accountNumber;
    @Value("${lipisha.payout.account.number}")
    public static String payoutAccountNumber;
    @Value("${lipisha.airtime.account.number}")
    public static String airtimeAccountNumber;
    @Value("${lipisha.mobile.number}")
    public static String testMobileNumber;
    private static final String BASE_URL = LipishaClient.SANDBOX_BASE_URL;
    private final LipishaClient lipishaClient;

    public LipishaPaymentAggregationService() {
        lipishaClient = new LipishaClient(apiKey, apiSignature, BASE_URL);
    }

    @Override
    public <T> T createUser(UserModel userModel) {
        // TODO  BUSINESS LOGIC HERE
        try {
            Call<UserResponse> clientUser = lipishaClient.createUser(userModel.getFullName(), userModel.getRole(), userModel.getEmail(), userModel.getMobileNumber(), userModel.getUserName(), userModel.getPassword());
            return (T) clientUser.execute().body();
        } catch (IOException e) {
            throw new RuntimeException("Something happened in Lipisha Side.");
        }
    }
}
