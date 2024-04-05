package com.paramuitos.dto;



import com.paramuitos.entities.Category;
import com.paramuitos.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(){}

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public  ProductDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        for(Category catDTO : entity.getCategories()){
            categories.add(new CategoryDTO(catDTO));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
