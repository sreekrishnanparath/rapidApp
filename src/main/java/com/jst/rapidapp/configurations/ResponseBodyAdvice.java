package com.jst.rapidapp.configurations;

import com.jst.rapidapp.beans.configuration.GenericResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

//@ControllerAdvice
public class ResponseBodyAdvice implements org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }



    @Override
    public Object beforeBodyWrite(Object object, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        GenericResponse<Object> genericResponse = new GenericResponse<>();
//        genericResponse.setStatus("OK"); // I guess that you need some logic here
//        genericResponse.setResponse(object);
//        genericResponse.setResponseTime("advice");
        return genericResponse;
    }
}