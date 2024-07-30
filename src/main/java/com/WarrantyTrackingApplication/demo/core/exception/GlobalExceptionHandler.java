package com.WarrantyTrackingApplication.demo.core.exception;

import com.WarrantyTrackingApplication.demo.core.exception.NotFoundException;
import com.WarrantyTrackingApplication.demo.core.result.ResultData;
import com.WarrantyTrackingApplication.demo.core.utiles.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.transform.Result;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){

        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());


        return  new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResultData<String>> handleRuntimeException(RuntimeException ex) {
        // Loglama işlemleri burada yapılabilir
        return new ResponseEntity<>(ResultHelper.Error500(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResultData<String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Geçersiz tarih/saat formatı";
        return new ResponseEntity<>(ResultHelper.dateFormat(errorMessage), HttpStatus.BAD_REQUEST);
    }
}
