package ra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.dto.request.category.CategoryAdd;
import ra.api.dto.request.category.CategoryUpdate;
import ra.api.dto.response.ApiResponse;
import ra.api.dto.response.CategoryDto;
import ra.api.exception.ResourcesNotFoundException;
import ra.api.service.ICategoryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api.hunghx.com/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    // Phương thức CRUD
    // lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        ApiResponse<List<CategoryDto>> res = ApiResponse.<List<CategoryDto>>builder()
                .code(200)
                .message("Success")
                .data(categoryService.findAll())
                .timeStamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) throws ResourcesNotFoundException {
        return  new ResponseEntity<>( ApiResponse.<CategoryDto>builder()
                .code(200)
                .message("Success")
                .data(categoryService.findById(id))
                .timeStamp(LocalDate.now())
                .build(), HttpStatus.OK);
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryAdd req){
        return new ResponseEntity<>(ApiResponse.<CategoryDto>builder()
                .code(201)
                .message("Success")
                .data(categoryService.create(req))
                .timeStamp(LocalDate.now())
                .build(),HttpStatus.CREATED); // 201
    }
    // Cập nhât theo id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryUpdate dto, @PathVariable Long id) throws ResourcesNotFoundException {
        return new ResponseEntity<>(ApiResponse.<CategoryDto>builder()
                .code(200)
                .message("Success")
                .data(categoryService.update(dto,id))
                .timeStamp(LocalDate.now())
                .build(),HttpStatus.OK); // 201;
    }
    // xóa theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) throws ResourcesNotFoundException {
        categoryService.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT); // 200
    }
}
