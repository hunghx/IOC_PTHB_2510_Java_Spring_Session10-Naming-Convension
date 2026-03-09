package ra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.dto.request.category.CategoryUpdate;
import ra.api.exception.ResourcesNotFoundException;
import ra.api.service.ICategoryService;

@RestController
@RequestMapping("/api.hunghx.com/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    // Phương thức CRUD
    // lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        return null;
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return  null;
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<?> createCategory(){
        return null;
    }
    // Cập nhât theo id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryUpdate dto, @PathVariable Long id) throws ResourcesNotFoundException {
        categoryService.update(dto,id);
        return null;
    }
    // xóa theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        return  null;
    }
}
