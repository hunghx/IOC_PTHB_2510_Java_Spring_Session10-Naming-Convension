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
       return categoryRepository.findAll()
               .stream().map(CategoryDto::new)
               .toList();
    }

    @Override
    public CategoryDto create(CategoryAdd categoryAdd) {
        Category en = Category.builder()
                .categoryName(categoryAdd.getCategoryName())
                .description(categoryAdd.getDescription())
                .status(categoryAdd.getStatus())
                .build();
        categoryRepository.save(en);
        return new CategoryDto(en);
    }

    @Override
    public CategoryDto update(CategoryUpdate categoryUpdate, Long id) throws ResourcesNotFoundException {
        Category entity = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));

        entity.setCategoryName(categoryUpdate.getCategoryName());
        entity.setDescription(categoryUpdate.getDescription());
        categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    @Override
    public CategoryDto findById(Long id) throws ResourcesNotFoundException {
        Category entity = categoryRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));
        return new CategoryDto(entity);
    }

    @Override
    public void delete(Long id) throws ResourcesNotFoundException {
        categoryRepository.findById(id).orElseThrow(() -> new ResourcesNotFoundException("Category not found with id = "+id));
        categoryRepository.deleteById(id);
    }
}
