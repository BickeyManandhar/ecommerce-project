package com.bickey.spring_boot_ecommerce.service;

import com.bickey.spring_boot_ecommerce.dto.ProductDto;
import com.bickey.spring_boot_ecommerce.entity.Product;
import com.bickey.spring_boot_ecommerce.mapper.ProductMapper;
import com.bickey.spring_boot_ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {
    Logger logger = Logger.getLogger(ProductService.class.getName());

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProduct(){
        List<Product> listOfProducts = productRepository.findAll();
        logger.info("Fetched products: " + listOfProducts.size());
        return ProductMapper.listOfProductToDto(listOfProducts);
    }

    public ProductDto getProductById(Long id){
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElse(null);
    }
}
