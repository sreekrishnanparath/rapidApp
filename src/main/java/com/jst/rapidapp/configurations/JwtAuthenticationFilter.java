package com.jst.rapidapp.configurations;


import com.jst.rapidapp.exception.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

       // try {
        String token = extractJwtFromRequest(httpServletRequest);

        System.out.println("token# "+token);

        try {
            if (token!=null && token.length()>0  && jwtUtil.validateAuthJwtToken(token)) {
                System.out.println("getRolesFromJwtToken# "+jwtUtil.getRolesFromJwtToken(token));
                UserDetails userDetails = new User(jwtUtil.getUserdetailsFromJwtToken(token),"",jwtUtil.getRolesFromJwtToken(token)) ;
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,"",jwtUtil.getRolesFromJwtToken(token));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else{
                System.out.println("not set");
            }
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            setErrorResponse(HttpStatus.UNAUTHORIZED,httpServletResponse,e);
        }

    }

    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex){
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
                httpStatus,
                ZonedDateTime.now());
        try {
            response.setStatus(status.value());
            response.setContentType("application/json");
            response.getWriter().write(exceptionResponse.convertToJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractJwtFromRequest(HttpServletRequest httpServletRequest){
        String headerAuth = httpServletRequest.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}
