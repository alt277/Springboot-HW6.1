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
import ru.geekbrains.persist.entity.Category;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.persist.repo.*;
import ru.geekbrains.persist.services.CategoryService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/category")
public class CategoryController  {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping
    public String allCategory(Model model,
                      @RequestParam(value = "title", required = false) String title,
                      @RequestParam(value = "price", required = false) BigDecimal price,
                              @RequestParam(value = "id", required = false) Integer id,
                              @RequestParam("page") Optional<Integer> page,
                      @RequestParam("size") Optional<Integer> size       ) {


        logger.info("Filtering by name: {}", title);



//                                                   с сорторовкой  по цене по возрастанию:
        PageRequest pageRequest = PageRequest.of(page.orElse(1) - 1, size.orElse(3),
                (Sort.by("price").ascending()));
        Specification<Category> spec = CategorySpecificatiom.trueLiteral();
            if (title != null && !title.isEmpty()) {
                spec = spec.and(CategorySpecificatiom.titleLike(title));
            }
            if (price != null ) {
                spec = spec.and(CategorySpecificatiom.priceGreaterThan(price));
            }

        model.addAttribute("categoryPage", categoryService.findAll(spec, pageRequest));
            return "category";
    }


}
