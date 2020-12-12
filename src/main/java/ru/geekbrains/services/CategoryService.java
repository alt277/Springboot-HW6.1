package ru.geekbrains.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repo.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page <Product> findAll(Specification spec, PageRequest pageRequest){
        return categoryRepository.findAll(spec, pageRequest);
    }



}
