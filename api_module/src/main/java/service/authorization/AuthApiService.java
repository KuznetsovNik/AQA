package service.authorization;

import dto.authorization_api.request.AuthRequest;
import dto.authorization_api.request.SettingsRequest;
import dto.authorization_api.response.BankInformation;
import dto.authorization_api.response.ExchangeRate;
import model.entity.NewUserRegistrationModel;
import model.entity.ReqHeaders;
import model.entity.ReqParams;
import model.response.ClassResponse;
import model.response.JsonResponse;
import service.BaseApiService;

import static constant.ApiEndpoints.*;
import static constant.ParamsList.ID_CLIENT;

public class AuthApiService extends BaseApiService {

    public JsonResponse postPhone(ReqHeaders<?, ?> headers, AuthRequest body) {
        return apiClient.post(BASE_PATH + LOGIN, headers, body);
    }

    public JsonResponse postPassport(ReqHeaders<?, ?> headers, AuthRequest body) {
        return apiClient.post(BASE_PATH + LOGIN, headers, body);
    }

    public JsonResponse getLogout(ReqHeaders<?, ?> authHeader) {
        return apiClient.get(BASE_PATH + LOGOUT, authHeader);
    }

    public JsonResponse postNotFingerprint(AuthRequest body) {
        return apiClient.post(BASE_PATH + LOGIN, body);
    }

    public JsonResponse getUserDate(ReqParams<?, ?> params, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + REGISTRATION, params, headers);
    }

    public ClassResponse<BankInformation[]> getListOfBankInformation() {
        return apiClient.get(BASE_PATH + BANK_BRANCH, BankInformation[].class);
    }

    public ClassResponse<ExchangeRate[]> getListOfExchangeRateResponse() {
        return apiClient.get(BASE_PATH + EXCHANGE_RATES, ExchangeRate[].class);
    }

    public JsonResponse getOldToken(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + CREDIT_PAYMENTS + ID_CLIENT, headers);
    }

    public JsonResponse getInfoCreditOldToken(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + CREDITS, headers);
    }

    public JsonResponse getCommissionAmounts(String transferType, String currencyCode, ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + COMMISSION_AMOUNTS
                +transferType+"/"+currencyCode+"/", headers);
    }

    public JsonResponse getHistoryDisplay(ReqHeaders<?, ?> headers) {
        return apiClient.get(BASE_PATH + HISTORY_DISPLAY, headers);
    }

    public JsonResponse getCheckUserRegistration(ReqParams<?, ?> reqParams) {
        return apiClient.get(BASE_PATH + REGISTRATION, reqParams);
    }

    public JsonResponse postNewUserReg(NewUserRegistrationModel newUserBody) {
        return apiClient.post(BASE_PATH + REGISTRATION + USER_PROFILE_NEW, newUserBody);
    }

    public JsonResponse putNewUserReg(NewUserRegistrationModel newUserBody) {
        return apiClient.put(BASE_PATH + REGISTRATION + USER_PROFILE_NEW, newUserBody);
    }

    public JsonResponse patchNewUserReg(NewUserRegistrationModel newUserBody) {
        return apiClient.patch(BASE_PATH + REGISTRATION + USER_PROFILE_NEW, newUserBody);
    }

    public JsonResponse getNewUserReg(NewUserRegistrationModel newUserBody) {
        return apiClient.get(BASE_PATH + REGISTRATION + USER_PROFILE_NEW, newUserBody);
    }

    public JsonResponse deleteNewUserReg() {
        return apiClient.delete(BASE_PATH + REGISTRATION + USER_PROFILE_NEW);
    }

    public JsonResponse postNewUserRegWithoutBody() {
        return apiClient.post(BASE_PATH + REGISTRATION + USER_PROFILE_NEW);
    }

    public JsonResponse getSettingsControlUnauthorizedUser(SettingsRequest request) {
        return apiClient.patch(BASE_PATH + USER_SETTINGS_CONTROLS, request);
    }
}