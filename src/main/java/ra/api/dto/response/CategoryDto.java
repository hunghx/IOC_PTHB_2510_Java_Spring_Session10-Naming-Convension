package ra.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ra.api.entity.Category;

@Getter
@Setter
//@Builder
public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private String description;

    public CategoryDto(Category en){
        this.categoryId = en.getCategoryId();
        this.categoryName = en.getCategoryName();
        this.description = en.getDescription();
    }
}
