package br.com.hrom.bookapi.endpoint;

import br.com.hrom.bookapi.exception.NotFoundException;
import br.com.hrom.bookapi.exception.ValidationError;
import br.com.hrom.bookapi.exception.ValidationError.ValidationErrorBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static br.com.hrom.bookapi.exception.ValidationError.Error;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ValidationErrorBuilder builder = ValidationError.builder().message("Validation error");

        exception
                .getBindingResult()
                .getAllErrors()
                .forEach(err -> builder.error(new Error(err.getObjectName(), err.getDefaultMessage())));

        return builder.build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException(NotFoundException exception) {

    }

}
