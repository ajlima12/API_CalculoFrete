package spring.controllers.advice;

import exceptions.EstadoNaoAceitoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import spring.dtos.response.ErrorResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e, HttpServletRequest request) {
        System.out.println("ERRO NAO MAPEADO: " + e.getMessage());
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage()
        );
    }
    @ResponseBody
    @ExceptionHandler(EstadoNaoAceitoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEstadoNaoAceitoException(EstadoNaoAceitoException e, HttpServletRequest request) {
        System.out.println("ERRO DE ESTADO NAO ACEITO: " + e.getMessage());
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage() + " - Estado: " + e.getEstado()
        );
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors()
                .forEach(v -> errors.add(v.getDefaultMessage()));
        return new ErrorResponse(
                LocalDateTime.now(),
                request.getServletPath(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                errors.toString());
    }
}
