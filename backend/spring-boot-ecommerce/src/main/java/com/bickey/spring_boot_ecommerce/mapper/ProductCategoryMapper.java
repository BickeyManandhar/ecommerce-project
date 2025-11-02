package com.bickey.spring_boot_ecommerce.mapper;

import com.bickey.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.bickey.spring_boot_ecommerce.entity.Product;
import com.bickey.spring_boot_ecommerce.entity.ProductCategory;

import java.util.List;

public class ProductCategoryMapper {

    public static List<ProductCategoryDto> listOfProductCategoryToDto(List<ProductCategory> productCategoryList) {
        return productCategoryList.stream()
                .map(pc->{
                    ProductCategoryDto productCategoryDto = new ProductCategoryDto();
                    productCategoryDto.setId(pc.getId());
                    productCategoryDto.setCategoryName(pc.getCategoryName());
                    productCategoryDto.setListOfProductId(pc.getProducts().stream()
                            .map(Product::getId)
                            .toList());
                    return productCategoryDto;
                }).toList();
    }

    public static ProductCategoryDto toDto(ProductCategory productCategory) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setCategoryName(productCategory.getCategoryName());
        productCategoryDto.setListOfProductId(productCategory.getProducts().stream()
                .map(Product::getId)
                .toList());
        return productCategoryDto;
    }
}
