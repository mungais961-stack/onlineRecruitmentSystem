package com.mungai.dev.onlineRecruitmentSystem.controllers;

import com.mungai.dev.onlineRecruitmentSystem.dtos.ErrorDto;
import com.mungai.dev.onlineRecruitmentSystem.dtos.ErrorResponse;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.DepartmentNotFoundException;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.RoleNotFoundException;
import com.mungai.dev.onlineRecruitmentSystem.exceptions.UserNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(IllegalArgumentException.class)

    public ResponseEntity<ErrorResponse>HandleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request){
    ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value()
            , ex.getMessage(),
            request.getDescription(false));
    return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        String errorMessage=ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Validation failed");
        ErrorDto errorDto=new ErrorDto(errorMessage);
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorDto> handleDepartmentNotFoundException(DepartmentNotFoundException ex){
        UUID departmentId=ex.getDepartment_Id();
        String message=String.format("Department with ID '%s' not found",departmentId);
        ErrorDto errorDto=new ErrorDto(message);
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorDto> handleRoleNotFoundException(RoleNotFoundException ex){
        UUID roleId=ex.getRole_Id();
        String message=String.format("Role with ID '%s' not found",roleId);
        ErrorDto errorDto=new ErrorDto(message);
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException ex){
        UUID userId=ex.getId();
        String message=String.format("User with ID '%s' not found",userId);
        ErrorDto errorDto=new ErrorDto(message);
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

}
