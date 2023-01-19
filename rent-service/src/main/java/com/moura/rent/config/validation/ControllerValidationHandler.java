package com.moura.rent.config.validation;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ControllerValidationHandler extends ResponseEntityExceptionHandler {
    private final String BAD_REQUEST = "BAD_REQUEST";

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String genericMessage = "Unacceptable JSON: " + ex.getMessage();
        String errorDetails = genericMessage;

        if(ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException ifx = (InvalidFormatException) ex.getCause();
            if(ifx.getTargetType()!=null && ifx.getTargetType().isEnum()){
                errorDetails = String.format("Invalid enum value: '%s' for the field: '%s'. The value must be one of: %s",
                        ifx.getValue(),ifx.getPath().get(ifx.getPath().size()-1).getFieldName(), Arrays.toString(ifx.getTargetType().getEnumConstants())
                );
            }
        }

        ErrorResponse errorResponse = new ErrorResponse(BAD_REQUEST, errorDetails);
        return super.handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse error = new ErrorResponse(BAD_REQUEST, "Invalid JSON value");

        List<CartridgeFieldsErrors> fieldsErrors = new ArrayList<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            CartridgeFieldsErrors fe = new CartridgeFieldsErrors(e.getField(), message);
            fieldsErrors.add(fe);
        });

        CartridgeValidationException errorResponse = new CartridgeValidationException(error, fieldsErrors);

        return super.handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST, request);
    }
}
