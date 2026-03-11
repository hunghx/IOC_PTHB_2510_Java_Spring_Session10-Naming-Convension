package ra.api.dto.request.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import ra.api.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
@Setter
@Getter
public class ProductAdd {

    private String sku;

    private String productName;

    private String description;

    private BigDecimal unitPrice;

    private Integer stockQuantity;

    private String image;

    private Long categoryId;

}
