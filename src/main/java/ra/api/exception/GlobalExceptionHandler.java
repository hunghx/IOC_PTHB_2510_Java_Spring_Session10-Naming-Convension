package ra.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.api.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // lỗi 404 : ko tim thấy tài nguyên
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(ResourcesNotFoundException e){
        ErrorResponse<String> err = ErrorResponse.<String>builder()
                .code(404)
                .message("NOT FOUND")
                .content(e.getMessage())
                .build();
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
