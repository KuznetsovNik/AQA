package gor_api.deposit_service;


import dto.authorization_api.request.CreateDepositRequest;
import dto.authorization_api.request.DepositsRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Step;


public class BaseDepositApplication extends BaseClassWithAuthToken {

    @Step("Формирование тела запроса для депозитов")
    public DepositsRequest depositsBody(String body) {
        return DepositsRequest.builder().body(body).build();
    }

    @Step("Формирование формы кредитной заявки")
    public CreateDepositRequest depositBody(String productID, String initialAmount,
                                            String accountNumber, String autoRenewal, String duration) {
        return CreateDepositRequest.builder()
                .productID(productID)
                .initialAmount(initialAmount)
                .accountNumber(accountNumber)
                .autoRenewal(autoRenewal)
                .duration(duration)
                .build();
    }
}