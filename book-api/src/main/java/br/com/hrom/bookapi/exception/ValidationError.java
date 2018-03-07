package br.com.hrom.bookapi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ValidationError {
    private String message;
    @Singular
    private List<Error> errors;

    @Data
    @AllArgsConstructor
    public static class Error {
        private String field;
        private String message;
    }
}
