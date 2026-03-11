package ra.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.api.dto.request.product.ProductAdd;
import ra.api.dto.request.product.ProductUpdate;
import ra.api.entity.Product;
import ra.api.exception.ResourcesNotFoundException;
import ra.api.repository.ICategoryRepository;
import ra.api.repository.IProductRepository;
import ra.api.service.ICategoryService;
import ra.api.service.IProductService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductAdd r) throws ResourcesNotFoundException {
        return productRepository.save(
                Product.builder()
                        .sku(r.getSku())
                        .productName(r.getProductName())
                        .description(r.getDescription())
                        .stockQuantity(r.getStockQuantity())
                        .category(categoryRepository.findById(r.getCategoryId()).orElseThrow(() -> new ResourcesNotFoundException("id ko tồn tại")))
                        .image(r.getImage())
                        .unitPrice(r.getUnitPrice())
                        .createdAt(LocalDate.now())
                        .build()
        );
    }

    @Override
    public Product update(ProductUpdate dto, Long aLong) throws ResourcesNotFoundException {
        Product en = productRepository.findById(aLong).orElseThrow(() -> new ResourcesNotFoundException("Id ko tồn tại"));
        en.setProductName(dto.getProductName());
        en.setDescription(dto.getDescription());
        en.setImage(dto.getImage());
        en.setUnitPrice(dto.getUnitPrice());
        en.setStockQuantity(dto.getStockQuantity());
        en.setUpdatedAt(LocalDate.now());
        en.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new ResourcesNotFoundException("id ko tìm thấy")));
        return productRepository.save(en);
    }

    @Override
    public Product findById(Long aLong) throws ResourcesNotFoundException {
       return productRepository.findById(aLong).orElseThrow(() -> new ResourcesNotFoundException("Id ko tồn tại"));
    }

    @Override
    public void delete(Long aLong) throws ResourcesNotFoundException {
        productRepository.findById(aLong).orElseThrow(() -> new ResourcesNotFoundException("id ko tìm thấy"));
        productRepository.deleteById(aLong);
    }
}
