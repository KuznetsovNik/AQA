package service.authorization;

import dto.authorization_api.request.*;
import dto.authorization_api.response.*;
import model.entity.ReqHeaders;
import model.entity.ReqParams;
import model.response.ClassResponse;
import model.response.JsonResponse;
import service.BaseApiService;

import static constant.ApiEndpoints.*;
import static constant.BaseHeaders.RequestHeaders.FINGERPRINT;
import static constant.ParamsList.ID_CLIENT_INVALID;
import static service.passport.PassportService.VALUE_FOR_HEADERS;

public class AuthApiWithTokenService extends BaseApiService {

    private final ReqHeaders<?, ?> headers;

    public AuthApiWithTokenService(ReqHeaders<?, ?> authHeader) {
        headers = authHeader;
        headers.add(FINGERPRINT, VALUE_FOR_HEADERS);
    }

    public JsonResponse getCreditOrder(ReqHeaders<?, ?> creditOrderHeaders) {
        return apiClient.get(BASE_PATH + CREDIT_ORDERS, creditOrderHeaders);
    }

    public JsonResponse getLogout(ReqHeaders<?, ?> header) {
        return apiClient.get(BASE_PATH + LOGOUT, header);
    }

    public ClassResponse<LoanInformation[]> getLoanInformation(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + CREDITS, headers, LoanInformation[].class);
    }

    public JsonResponse getPaymentSchedule(String idCredits, ReqHeaders<?, ?> header) {
        ReqParams<?, ?> reqParams = new ReqParams<>();
        reqParams.add("id", idCredits);
        return apiClient.get(BASE_PATH + CREDIT_PAYMENTS, reqParams, header);
    }

    public ClassResponse<CreditProducts[]> getCreditProducts(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + CREDITS_PRODUCTS, headers, CreditProducts[].class);
    }

    public JsonResponse postSpecSymbol(ReqHeaders<?, ?> headers, LoanInformationRequest bodyCredit) {
        return apiClient.post(BASE_PATH + CREDIT_ORDERS, headers, bodyCredit);
    }

    public JsonResponse getInfoCreditInvalidParams(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + CREDITS + ID_CLIENT_INVALID, headers);
    }

    public ClassResponse<CreditApplication[]> postCreditApplication(ReqHeaders<?, ?> headers, LoanInformationRequest bodyCredit) {
        return apiClient.post(BASE_PATH + CREDIT_ORDERS, headers, bodyCredit, CreditApplication[].class);
    }

    public ClassResponse<ListAutotransfer> getAutoTransfersClass(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + AUTO_TRANSFERS, headers, ListAutotransfer.class);
    }

       public JsonResponse  getAutoTransfers(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + AUTO_TRANSFERS, headers);
    }

    public JsonResponse getCommissionAmounts(String transferType, String currencyCode, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + COMMISSION_AMOUNTS
                + transferType + "/" + currencyCode + "/", headers);
    }

    public ClassResponse<HistoryMT[]> getHistoryDisplay(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + HISTORY_DISPLAY, headers, HistoryMT[].class);
    }

    public JsonResponse getTranslationDetails(String transfersNumber, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + TRANSLATION_DETAILS + transfersNumber + "/", headers);
    }

    public JsonResponse patchChangStatusOfTransfer(String transfersNumber, ReqHeaders<?, ?> headers,
                                                   StatusRequest bodyStatus) {
        return apiClient.patch(BASE_PATH + TRANSFER + transfersNumber + "/", headers, bodyStatus);
    }

    public JsonResponse patchAutoTransactionStatus(String transfersNumber, ReqHeaders<?, ?> headers,
                                                   AutoTransactionStatus bodyAutoTransactionStatus ) {
        return apiClient.patch(BASE_PATH + AUTO_TRANSFERS + transfersNumber + "/", headers,
                bodyAutoTransactionStatus);
    }

    public JsonResponse postForMoneyTransfer(ReqHeaders<?, ?> headers, MoneyTransferRequest transferBody) {
        return apiClient.post(BASE_PATH + MONEY_TRANSFER, headers, transferBody);
    }

    public JsonResponse deleteAutoTransaction(String transfersNumber, ReqHeaders<?, ?> headers) {
        return apiClient.delete(BASE_PATH + TRANSFER + transfersNumber + "/", headers);
    }

    public JsonResponse postNewDepositAgreement( ReqHeaders<?, ?> headers, CreateDepositRequest depositBody) {
        return apiClient.post(BASE_PATH + DEPOSITS_NEW, headers,  depositBody);
    }

    public JsonResponse getJsonDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + DEPOSITS, headers);
    }

    public JsonResponse getDepositsAgreementInfo(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + DEPOSITS_INFO_AGREEMENT, headers);
    }

    public ClassResponse<Deposits[]> getDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + DEPOSITS, headers, Deposits[].class);
    }

    public JsonResponse getDepositsWithBadUrl(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + BAD_DEPOSITS_URL, headers);
    }

    public JsonResponse postDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.post(BASE_PATH + DEPOSITS, headers);
    }

    public JsonResponse putDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.put(BASE_PATH + DEPOSITS, headers);
    }

    public JsonResponse patchDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.patch(BASE_PATH + DEPOSITS, headers);
    }

    public JsonResponse deleteDeposits(ReqHeaders<?, ?> headers) {
        return apiClient.delete(BASE_PATH + DEPOSITS, headers);
    }

    public JsonResponse getDepositsWithBody(ReqHeaders<?, ?> headers, DepositsRequest depositsBody) {
        return apiClient.get(BASE_PATH + DEPOSITS, headers, depositsBody);
    }

    public JsonResponse getDeposit(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + DEPOSITS + agrId, headers);
    }

    public JsonResponse postDeposit(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.post(BASE_PATH + DEPOSITS + agrId, headers);
    }

    public JsonResponse putDeposit(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.put(BASE_PATH + DEPOSITS + agrId, headers);
    }

    public JsonResponse patchDeposit(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.patch(BASE_PATH + DEPOSITS + agrId, headers);
    }

    public JsonResponse deleteDeposit(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.delete(BASE_PATH + DEPOSITS + agrId, headers);
    }

    public JsonResponse getDepositWithBadUrl(String agrId, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + BAD_DEPOSITS_URL + agrId, headers);
    }

    public JsonResponse getDepositWithBody(String agrId, ReqHeaders<?, ?> headers, DepositsRequest depositsBody) {
        return apiClient.get(BASE_PATH + DEPOSITS + agrId, headers, depositsBody);
    }

    public JsonResponse getSettingsSMSNotification(ReqHeaders<?, ?> headers, SettingsRequest request) {
        return apiClient.patch(BASE_PATH + USER_SETTINGS_SMS_NOTIFICATION, headers, request);
    }

    public JsonResponse getSettingsPUSHNotification(ReqHeaders<?, ?> headers, SettingsRequest request) {
        return apiClient.patch(BASE_PATH + USER_SETTINGS_PUSH_NOTIFICATION, headers, request);
    }

    public JsonResponse getAuthorization(ReqHeaders<?, ?> headers, AuthRequest request) {
        return apiClient.post(BASE_PATH + LOGIN, headers, request);
    }

    public JsonResponse getSettingsControl(ReqHeaders<?, ?> headers, SettingsRequest request) {
        return apiClient.patch(BASE_PATH + USER_SETTINGS_CONTROLS, headers, request);
    }

    public JsonResponse getSettingsPassword(ReqHeaders<?, ?> headers, SettingsRequest request) {
        return apiClient.patch(BASE_PATH + USER_SETTINGS_PASSWORD, headers, request);
    }
}