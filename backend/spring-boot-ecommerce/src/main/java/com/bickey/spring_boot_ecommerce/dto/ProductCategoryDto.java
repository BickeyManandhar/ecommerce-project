package com.bickey.spring_boot_ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoryDto {

    private Long id;

    private String categoryName;

    private List<Long> listOfProductId;
}
