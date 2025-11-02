package com.bickey.spring_boot_ecommerce.controller;

import com.bickey.spring_boot_ecommerce.dto.ProductDto;
import com.bickey.spring_boot_ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
@Slf4j
public class ProductController {

    private static int callCount = 0;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        callCount++;
        log.info("Number of calls made on getAllProduct(): "+ callCount);
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping(value="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        callCount++;
        log.info("Number of calls made on getProductById(): "+ callCount);
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
}
