package ra.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.api.dto.request.category.CategoryAdd;
import ra.api.dto.request.category.CategoryUpdate;
import ra.api.dto.response.CategoryDto;
import ra.api.entity.Category;
import ra.api.exception.ResourcesNotFoundException;
import ra.api.repository.ICategoryRepository;
import ra.api.service.ICategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<CategoryDto> findAll() {
        return List.of();
    }

    @Override
    public CategoryDto create(CategoryAdd categoryAdd) {
        return null;
    }

    @Override
    public CategoryDto update(CategoryUpdate categoryUpdate, Long id) throws ResourcesNotFoundException {
        Category entity = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));
        return null;
    }

    @Override
    public CategoryDto findById(Long id) throws ResourcesNotFoundException {
        Category entity = categoryRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));
        return CategoryDto.builder()
                .categoryId(entity.getCategoryId())
                .categoryName(entity.getCategoryName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public void delete(Long id) throws ResourcesNotFoundException {
        categoryRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));
        categoryRepository.deleteById(id);
    }
}
