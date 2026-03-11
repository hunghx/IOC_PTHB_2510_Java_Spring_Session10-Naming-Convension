package ra.api.dto.request.category;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryUpdate {

    private String categoryName;
    private String description;
}
