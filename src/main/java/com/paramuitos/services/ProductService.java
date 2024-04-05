package com.paramuitos.services;

import com.paramuitos.dto.CategoryDTO;
import com.paramuitos.dto.ProductDTO;
import com.paramuitos.entities.Category;
import com.paramuitos.entities.Product;
import com.paramuitos.repositories.CategoryRepository;
import com.paramuitos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDTO : dto.getCategories()){
            Category category = categoryRepository.getReferenceById(catDTO.getId());
            category.setId(catDTO.getId());
            entity.getCategories().add(category);
        }

        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }
}
