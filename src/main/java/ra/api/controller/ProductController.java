package ra.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api.hunghx.com/v1/products")
public class ProductController {
    // Phương thức CRUD
    // lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return null;
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        return  null;
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<?> createProduct(){
        return null;
    }
    // Cập nhât theo id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id){
        return null;
    }
    // xóa theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        return  null;
    }
}
