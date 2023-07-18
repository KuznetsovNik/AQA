package gor_api.credit_service;

import dto.authorization_api.request.LoanInformationRequest;
import gor_api.BaseClassWithAuthToken;
import io.qameta.allure.Step;

public class BaseCreditApplication extends BaseClassWithAuthToken {

    @Step("Формирование формы кредитной заявки")
    public LoanInformationRequest creditBody(String periodMonth, String amount, String averageMonthlyIncome,
                                             String averageMonthlyExpenditure, String productId,
                                             String employerIdentificationNumber) {
        return LoanInformationRequest.builder()
                .period_month(periodMonth)
                .amount(amount)
                .average_monthly_income(averageMonthlyIncome)
                .average_monthly_expenditure(averageMonthlyExpenditure)
                .product_id(productId)
                .employer_identification_number(employerIdentificationNumber)
                .build();
    }
}