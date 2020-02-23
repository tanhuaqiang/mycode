package com.daling.aop;

import com.daling.bean.DLoginUser;
import com.daling.platform.util.Jackson2Helper;
import com.daling.util.web.WebUtil;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 登录用户的拦截器
 */
public class LoginValidateInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(LoginValidateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LoginValidateInterceptor preHandle " + request.getRequestURL());
        String realUri = WebUtil.getNoAppNamedRequestURI(request);
        HttpSession session = request.getSession();
        DLoginUser dLoginUser = (DLoginUser) session.getAttribute("user");
        if (dLoginUser == null || !dLoginUser.isLogined()) {
            // 未登录，转向登录页面！
//            PrintWriter writer = response.getWriter();
//            Map<String, Object> data = Maps.newHashMap();
//            data.put("url", realUri);
//            data.put("message", "用户未登录!");
//            data.put("userInfo", dLoginUser);
//            writer.print(Jackson2Helper.toJsonString(data));
//            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
