package com.dalingjia.spring.service;


class LoginService {
    public void login() {
        System.out.println("*************execute LoginService***************");
    }
}


public class LoginResource {
    private LoginService loginService;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login() {
        loginService.login();
    }
}