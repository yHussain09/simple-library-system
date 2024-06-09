package com.example.simplelibrarysystem.exception.handler;

import com.example.simplelibrarysystem.exception.CustomBadRequestException;
import com.example.simplelibrarysystem.exception.CustomInternalServerException;
import com.example.simplelibrarysystem.rest.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandlerAdviceController {
    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    RestResponse handleBadRequest(CustomBadRequestException exception) {
        RestResponse restResponse = new RestResponse();
        restResponse.setLastModified(new Date());
        restResponse.setMessage(exception.getMessage());
        restResponse.setStatusInfo(HttpStatus.BAD_REQUEST);
        return restResponse;
    }

    @ExceptionHandler(CustomInternalServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    RestResponse handleInternalServerError(CustomInternalServerException exception) {
        RestResponse restResponse = new RestResponse();
        restResponse.setLastModified(new Date());
        restResponse.setMessage(exception.getMessage());
        restResponse.setStatusInfo(HttpStatus.INTERNAL_SERVER_ERROR);
        return restResponse;
    }
}
