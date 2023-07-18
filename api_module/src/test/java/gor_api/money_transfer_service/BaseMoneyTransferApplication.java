package gor_api.money_transfer_service;

import dto.authorization_api.request.AutoTransactionStatus;
import dto.authorization_api.request.MoneyTransferRequest;
import dto.authorization_api.request.StatusRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Step;

public class BaseMoneyTransferApplication extends BaseClassWithAuthToken {

    @Step("Формирование формы кредитной заявки")
    public MoneyTransferRequest transferBody(long senderCardNumber, int transferType, String transferSum,
                                             String currencyFrom, String currencyTo, int payeeAccountNumber,
                                             String commission, String purpose, int transferSystem,
                                             String currencyExchange, int authorizationCode, String exchSum,
                                             String exchRate, String mobilePhone) {
        return MoneyTransferRequest.builder()
                .senderCardNumber(senderCardNumber)
                .transferType(transferType)
                .transferSum(transferSum)
                .currencyFrom(currencyFrom)
                .currencyTo(currencyTo)
                .payeeAccountNumber(payeeAccountNumber)
                .commission(commission)
                .purpose(purpose)
                .transferSystem(transferSystem)
                .currencyExchange(currencyExchange)
                .authorizationCode(authorizationCode)
                .exchSum(exchSum)
                .exchRate(exchRate)
                .mobilePhone(mobilePhone)
                .build();
    }

    @Step("Формирование формы для замены статуса перевода")
    public StatusRequest statusBody(String status) {
        return StatusRequest.builder()
                .status(status)
                .build();
    }
    @Step("Формирование формы для добавления переводу статуса автоперевода")
    public AutoTransactionStatus autoTransactionStatusBody(int periodicity, String startDate, String expirationDate) {
        return AutoTransactionStatus.builder()
                .periodicity(periodicity)
                .startDate(startDate)
                .expirationDate(expirationDate)
                .build();
    }
}