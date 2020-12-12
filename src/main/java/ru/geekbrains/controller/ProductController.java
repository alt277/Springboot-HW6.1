package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repo.ProductRepo;
import ru.geekbrains.repo.ProductRepository;
import ru.geekbrains.repo.specifications.ProductSpecificatiom;
import ru.geekbrains.services.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;


    @GetMapping
    public String allProducts(Model model,
                              @RequestParam(value = "title", required = false) String title,
                              @RequestParam(value = "price", required = false) BigDecimal price,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {


        logger.info("Filtering by name: {}", title);

        PageRequest pageRequest = PageRequest.of(page.orElse(1) - 1, size.orElse(4),
                Sort.by("title").ascending().and(Sort.by("price").ascending()));
        Specification<Product> spec = ProductSpecificatiom.trueLiteral();
        if (title != null && !title.isEmpty()) {
            spec = spec.and(ProductSpecificatiom.titleLike(title));
        }
        if (price != null) {
            spec = spec.and(ProductSpecificatiom.priceGreaterThan(price));
        }

        model.addAttribute("productPage", productRepository.findAll(spec, pageRequest));

        return "products";
    }

    @GetMapping("/max")
    public String maxPrice(Model model) {
        Product max = new Product();
        max = productService.findMaxPrice();
        model.addAttribute("products", max);
        return "prices";
    }

    @GetMapping("/min")
    public String minPrice(Model model) {
        Product min = new Product();
//        min = productRepo.findMinPrice();
        min = productService.findMinPrice();
        model.addAttribute("products", min);
        return "prices";
    }

    @GetMapping("/min-max")
    public String minmaxPrice(Model model) {

        List<Product> productList;
        productList = productService.findMinMaxPrice();
        model.addAttribute("products", productList);
        return "prices";
    }

}
