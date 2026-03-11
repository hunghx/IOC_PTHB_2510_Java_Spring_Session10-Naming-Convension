package ra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.api.dto.request.product.ProductAdd;
import ra.api.dto.request.product.ProductUpdate;
import ra.api.dto.response.ApiResponse;
import ra.api.entity.Product;
import ra.api.exception.ResourcesNotFoundException;
import ra.api.service.IProductService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api.hunghx.com/v1/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    // Phương thức CRUD
    // lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(ApiResponse.<List<Product>>builder()
                .code(200)
                .message("successs")
                .data(productService.findAll())
                .timeStamp(LocalDate.now())
                .build(), HttpStatus.OK);
    }

    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) throws ResourcesNotFoundException {
        return new ResponseEntity<>(ApiResponse.<Product>builder()
                .code(200)
                .message("successs")
                .data(productService.findById(id))
                .timeStamp(LocalDate.now())
                .build(), HttpStatus.OK);
    }

    // Thêm mới
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductAdd re) throws ResourcesNotFoundException {
        return new ResponseEntity<>(ApiResponse.<Product>builder()
                .code(201)
                .message("successs")
                .data(productService.create(re))
                .timeStamp(LocalDate.now())
                .build(), HttpStatus.OK);
    }
    // Cập nhât theo id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdate re, @PathVariable Long id) throws ResourcesNotFoundException {
        return new ResponseEntity<>(ApiResponse.<Product>builder()
                .code(200)
                .message("successs")
                .data(productService.update(re,id))
                .timeStamp(LocalDate.now())
                .build(), HttpStatus.OK);
    }
    // xóa theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ResourcesNotFoundException {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
