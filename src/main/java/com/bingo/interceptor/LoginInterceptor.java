package com.bingo.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:yaobin
 * @date:2020/7/22,13:52
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("login interceptor is run ...");
//        //放行option请求,否则无法让前端带上自定义的header信息,导致sessionId改变,shiro验证失效
//        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            return true;
//        }
//        Subject subject = SecurityUtils.getSubject();
//
//        if(!subject.isAuthenticated()){
//            return false;
//        }

        return true;
    }

    private boolean beginWith(String page, String[] requireAuthPages) {
        boolean result=false;

        for (String requireAuthPage : requireAuthPages) {
            if(StringUtils.startsWith(page,requireAuthPage)){
                result=true;
                break;
            }
        }
        return result;
    }
}
