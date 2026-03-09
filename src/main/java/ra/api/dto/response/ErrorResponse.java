package ra.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse<T> {
    private int code;
    private String message;
    private T content;
}
