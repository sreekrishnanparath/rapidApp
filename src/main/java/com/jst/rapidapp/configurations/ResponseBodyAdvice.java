package com.jst.rapidapp.configurations;

import com.jst.rapidapp.beans.configuration.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice
public class ResponseBodyAdvice implements org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice<Object> {


    @Autowired
    Environment environment;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }



    @Override
    public Object beforeBodyWrite(Object object, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        String host = environment.getProperty("HOSTNAME");
        GenericResponse<Object> genericResponse = new GenericResponse<>();
        genericResponse.setStatus(HttpStatus.OK); // I guess that you need some logic here
        genericResponse.setResult(object);
        genericResponse.setEnvironment(host+" - "+environment.getProperty("local.server.port"));
        return genericResponse;
    }
}