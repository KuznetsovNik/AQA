package gor_api;

import dto.authorization_api.request.AuthRequest;
import dto.authorization_api.response.AuthResponse;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import model.entity.NewUserRegistrationModel;
import model.entity.ReqHeaders;
import model.response.JsonResponse;
import org.testng.annotations.AfterMethod;
import service.authorization.AuthApiWithTokenService;
import service.passport.PassportService;

import static constant.BaseHeaders.Authorization.BEARER;
import static constant.BaseHeaders.RequestHeaders.AUTHORIZATION;
import static constant.DataConstants.LOGIN_VALID_RU;
import static helper.ObjectMapperHelper.mapJsonToObject;
import static jdbc.data_base_requests.UserServiceDataBaseRequests.getClientByPhoneNumber;

@Slf4j
public class BaseClassWithAuthToken {
    public PassportService passportService;
    public AuthApiWithTokenService authApiWithTokenService;
    protected ReqHeaders<?, ?> authHeaders;
    protected String accessToken;
    protected AuthResponse authResponse;

    public BaseClassWithAuthToken() {
        passportService = new PassportService();
        authHeaders = new ReqHeaders<>();
        authApiWithTokenService = new AuthApiWithTokenService(authHeaders);
    }

    @Step("Авторизуемся и получаем accessToken")
    public void setAccessToken(String code, String login, String password, String type) {
        JsonResponse auth = authApiWithTokenService.getAuthorization(authHeaders,
                body(code, login, password, type));
        AuthResponse authResponse = mapJsonToObject(auth, AuthResponse.class);
        authHeaders.add(AUTHORIZATION, BEARER + authResponse.getAccessToken());
    }

    @Step("Формирование тела для авторизации по телефону")
    public AuthRequest body(String code, String login, String password, String type) {
        return AuthRequest.builder()
                .code(code)
                .login(login)
                .password(password)
                .type(type)
                .build();
    }

    @Step("Получаем данные пользователя по номеру телефона")
    protected NewUserRegistrationModel getUser() {
        return getClientByPhoneNumber(LOGIN_VALID_RU);
    }

    @AfterMethod(alwaysRun = true)
    public void logOut() {
        authApiWithTokenService.getLogout(authHeaders);
        log.info("Выход из личного кабинета / Exit from personal account");
    }
}