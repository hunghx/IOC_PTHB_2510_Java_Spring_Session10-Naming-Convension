package ra.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private String description;
}
