package com.designnote.knowledgehub.exception;

import com.designnote.knowledgehub.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.log4j.Logger;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    // Capture all exceptions
    @ExceptionHandler({Exception.class})
    public ResponseMessage exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        logger.error("global handling",e);
        return new ResponseMessage(500,"error",null);
    }

    // Capture Argument validation
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseMessage validationExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        logger.error("Validation handling",e);
        return new ResponseMessage(500,"Bad Request, argument not validated",null);
    }

    // Capture DB non-existent value exception
    @ExceptionHandler(value = {DbEntityException.class})
    public ResponseMessage nonExistentDbValueExceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response){
        logger.error("User requests non-existent value",e);
        return new ResponseMessage(400,"Bad Request :" + e.getMessage(),null);
    }


//

}
