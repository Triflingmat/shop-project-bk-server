package com.project.shop.interceptors;

import com.project.shop.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

//拦截器
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        logger.info("接收到的Authorization头: {}", token); // 记录接收到的token

        try{
            Map<String,Object> claims = JwtUtil.parseToken(token);
            logger.info("Token验证成功，claims: {}", claims); // 记录验证成功的claims
            return true;
        }catch (Exception e){
            logger.error("Token验证失败，token: {}, 错误信息: {}", token, e.getMessage(), e); // 记录详细错误信息
            response.setStatus(401);
            return false;
        }
    }
}
