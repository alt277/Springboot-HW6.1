package ru.geekbrains.controller.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.views.ProductView;
import ru.geekbrains.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products/api/v1")
public class ProductRestController {

    private ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ProductView.FullProduct.class)
    public List<Product> allProduct() {
        return productService.findAll();
    }

    @GetMapping(value = "/productsAndCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ProductView.IdNamePrceCategory.class)
    public List<Product> products() {
        return productService.findAll();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> productsToJson() {
        return productService.findAll();
    }


    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ProductView.Id.class)
    @ResponseBody
    public List<Product> productIdToJson() {
        return productService.findAll();
    }

    @GetMapping(value = "/idName", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ProductView.IdName.class)
    @ResponseBody
    public List<Product> productIdNameToJson() {
        return productService.findAll();
    }

    @GetMapping(value = "/ProductAndCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(ProductView.FullProduct.class)
    @ResponseBody
    public List<Product> productFullPlainToJson() {
        return productService.findAll();
    }


    @GetMapping(value = "/entityWithPaging", params = {"page", "size"})
    @JsonView(ProductView.FullProduct.class)
    public ResponseEntity entityWithPaging(
            Pageable pageable,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        PageRequest pageRequest1 = PageRequest.of(page, size);

        System.out.println(pageable);
        System.out.println(pageRequest1);

        Map<String, Object> map = new HashMap<>();
        map.put("products", productService.findAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
