package com.bickey.spring_boot_ecommerce.controller;

import com.bickey.spring_boot_ecommerce.dto.ProductCategoryDto;
import com.bickey.spring_boot_ecommerce.mapper.ProductCategoryMapper;
import com.bickey.spring_boot_ecommerce.repository.ProductCategoryRepository;
import com.bickey.spring_boot_ecommerce.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-category")
@CrossOrigin("http://localhost:4200")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductCategoryDto>> getAllProductCategory(){
        return new ResponseEntity<>(productCategoryService.getAllProductCategory(), HttpStatus.OK);
    }

    @GetMapping(value="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategoryDto> getProductCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(productCategoryService.getProductCategoryById(id), HttpStatus.OK);
    }
}
