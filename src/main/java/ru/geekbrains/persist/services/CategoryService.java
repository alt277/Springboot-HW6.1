package ru.geekbrains.persist.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.persist.repo.CategoryRepository;

import java.util.List;

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
