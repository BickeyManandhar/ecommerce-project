package com.bickey.spring_boot_ecommerce.mapper;

import com.bickey.spring_boot_ecommerce.dto.ProductDto;
import com.bickey.spring_boot_ecommerce.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDto> listOfProductToDto(List<Product> products) {
        return products.stream()
                .map(p->{
                    ProductDto productDto = new ProductDto();
                    productDto.setId(p.getId());
                    productDto.setName(p.getName());
                    productDto.setDescription(p.getDescription());
                    productDto.setCategoryId(p.getCategory().getId());
                    productDto.setActive(p.isActive());
                    productDto.setUnitPrice(p.getUnitPrice());
                    productDto.setImageUrl(p.getImageUrl());
                    productDto.setSku(p.getSku());
                    productDto.setUnitsInStock(p.getUnitsInStock());
                    productDto.setDateCreated(p.getDateCreated());
                    productDto.setLastUpdated(p.getLastUpdated());
                    return productDto;
                })
                .toList();
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setActive(product.isActive());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setSku(product.getSku());
        productDto.setUnitsInStock(product.getUnitsInStock());
        productDto.setDateCreated(product.getDateCreated());
        productDto.setLastUpdated(product.getLastUpdated());
        return productDto;
    }
}
