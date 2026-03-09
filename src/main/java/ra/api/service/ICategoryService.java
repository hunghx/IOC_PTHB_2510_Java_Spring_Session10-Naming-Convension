package ra.api.service;

import ra.api.dto.request.category.CategoryAdd;
import ra.api.dto.request.category.CategoryUpdate;
import ra.api.dto.response.CategoryDto;

public interface ICategoryService extends IGenericService<CategoryAdd,CategoryUpdate,Long,CategoryDto > {

}
