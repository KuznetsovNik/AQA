package gor_api.authorization_one_time;

import dto.authorization_api.request.AuthRequest;
import gor_api.BaseClass;
import io.qameta.allure.Step;

public class BaseAuthorization extends BaseClass {

    @Step("Формирование тела для авторизации")
    public AuthRequest body(String code, String login, String password, String type) {
        return AuthRequest.builder()
                .code(code)
                .login(login)
                .password(password)
                .type(type)
                .build();
    }

    @Step("Формирование тела для авторизации без кода")
    public AuthRequest bodyWithoutCode(String login, String password, String type) {
        return AuthRequest.builder()
                .login(login)
                .password(password)
                .type(type)
                .build();
    }

    @Step("Формирование тела для авторизации без логина")
    public AuthRequest bodyWithoutLogin(String code, String password, String type) {
        return AuthRequest.builder()
                .code(code)
                .password(password)
                .type(type)
                .build();
    }

    @Step("Формирование тела для авторизации без пароля")
    public AuthRequest bodyWithoutPassword(String code, String login, String type) {
        return AuthRequest.builder()
                .code(code)
                .login(login)
                .type(type)
                .build();
    }

    @Step("Формирование тела для авторизации без типа")
    public AuthRequest bodyWithoutType(String code, String login, String password) {
        return AuthRequest.builder()
                .code(code)
                .login(login)
                .password(password)
                .build();
    }

    @Step("Формирование тела для авторизации. Отправка пустого тела")
    public AuthRequest body() {
        return AuthRequest.builder().build();
    }
}