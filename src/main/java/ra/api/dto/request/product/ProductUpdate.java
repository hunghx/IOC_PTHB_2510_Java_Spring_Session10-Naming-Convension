package ra.api.dto.request.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class ProductUpdate {

    private String productName;

    private String description;

    private BigDecimal unitPrice;

    private Integer stockQuantity;

    private String image;

    private Long categoryId;
}
