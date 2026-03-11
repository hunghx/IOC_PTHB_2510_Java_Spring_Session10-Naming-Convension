package ra.api.dto.request.category;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAdd {
    private String categoryName;

    private String description;

    private Boolean status;
}
