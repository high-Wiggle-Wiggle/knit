package com.ggumtle.ggumtle.shared.error;

import com.ggumtle.ggumtle.shared.response.ErrorResponse;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingRequestValueException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> missingRequestValueException(MissingRequestValueException e) {

        return ResponseEntity
                .status(GlobalErrorProperty.BAD_REQUEST.getStatus())
                .body(new ErrorResponse(GlobalErrorProperty.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> missingRequestValueException(MissingServletRequestPartException e) {

        return ResponseEntity
                .status(GlobalErrorProperty.BAD_REQUEST.getStatus())
                .body(new ErrorResponse(GlobalErrorProperty.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    public ResponseEntity<ErrorResponse> handleFileSizeLimitExceededException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.PAYLOAD_TOO_LARGE)
                .body(new ErrorResponse(GlobalErrorProperty.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ResponseEntity<ErrorResponse> handleError(HttpMediaTypeNotSupportedException e) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(new ErrorResponse(GlobalErrorProperty.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(MatzipException.class)
    public ResponseEntity<ErrorResponse> handleMaruException(MatzipException e) {
        return ResponseEntity
                .status(e.getErrorProperty().getStatus())
                .body(new ErrorResponse(e.getErrorProperty()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(GlobalErrorProperty.INTERNAL_SERVER_ERROR.getStatus())
                .body(new ErrorResponse(GlobalErrorProperty.INTERNAL_SERVER_ERROR));
    }
}