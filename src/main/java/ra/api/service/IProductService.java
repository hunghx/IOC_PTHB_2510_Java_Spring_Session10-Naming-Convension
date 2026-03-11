package ra.api.service;

import ra.api.dto.request.product.ProductAdd;
import ra.api.dto.request.product.ProductUpdate;
import ra.api.entity.Product;

public interface IProductService extends IGenericService<ProductAdd, ProductUpdate, Long, Product>{
}
