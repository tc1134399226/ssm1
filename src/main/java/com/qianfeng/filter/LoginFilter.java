package com.qianfeng.filter;

import com.qianfeng.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/ssm1/loginCheck")||uri.equals("/ssm1/registerUser")||"/ssm1/login.html".equals(uri)||"/ssm1/reg.html".equals(uri)){
           return true;
        }
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("userinfo");
        if (user!=null){
            return true;
        }
            httpServletRequest.setAttribute("msg", "您还没有登录，请先登录！");
            httpServletRequest.getRequestDispatcher("login.html").forward(httpServletRequest,httpServletResponse);
            return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
