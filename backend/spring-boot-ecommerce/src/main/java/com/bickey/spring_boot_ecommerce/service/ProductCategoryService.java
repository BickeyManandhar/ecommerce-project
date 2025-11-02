package com.bickey.spring_boot_ecommerce.service;

import com.bickey.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.bickey.spring_boot_ecommerce.mapper.ProductCategoryMapper;
import com.bickey.spring_boot_ecommerce.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategoryDto> getAllProductCategory(){
        return ProductCategoryMapper.listOfProductCategoryToDto(productCategoryRepository.findAll());
    }

    public ProductCategoryDto getProductCategoryById(Long id){
        return productCategoryRepository.findById(id)
                .map(ProductCategoryMapper::toDto)
                .orElse(null);
    }

}
