package com.daling.aop;

import com.daling.bean.DLoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserArgumentResolver implements WebArgumentResolver {

    Logger logger = LoggerFactory.getLogger(UserArgumentResolver.class);


    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (methodParameter.getParameterType().equals(DLoginUser.class)) {
            HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
            HttpSession session = request.getSession();
            DLoginUser dLoginUser = (DLoginUser) session.getAttribute("user");

            if (dLoginUser == null) {
                dLoginUser = new DLoginUser();
            } else {
                dLoginUser.setLogonToken(dLoginUser.getLogonToken());
            }
            logger.debug("LoginUser={}", dLoginUser);
            this.setupVal(request, dLoginUser);
            return dLoginUser;
        }
        return UNRESOLVED;
    }

    private void setupVal(HttpServletRequest request, DLoginUser dLoginUser) {
        // 放置登录ip, url
        dLoginUser.setClientIp(request.getRemoteAddr());
        dLoginUser.setCurrentUrl(request.getRequestURI());
        return;
    }
}