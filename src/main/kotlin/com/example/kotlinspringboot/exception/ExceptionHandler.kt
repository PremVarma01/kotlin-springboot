package com.example.kotlinspringboot.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception


// message , status, code

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ApiError> {
        var error = ApiError(exception.message ?: "Something went wrong -> Exception")
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(MovieException::class)
    fun movieHandleException(exception: Exception): ResponseEntity<ApiError> {
        var error = ApiError(exception.message ?: "Something went wrong")
        return ResponseEntity(error, error.status)
    }

}