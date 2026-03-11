package ra.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private LocalDate timeStamp;
}
