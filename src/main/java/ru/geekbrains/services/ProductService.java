package ru.geekbrains.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repo.ProductRepo;
import ru.geekbrains.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductRepo productRepo;

    public ProductService(ProductRepository productRepository, ProductRepo productRepo) {
        this.productRepository = productRepository;
        this.productRepo = productRepo;
    }
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
      public Product findMinPrice(){
        return productRepository.findMinPrice();
      }
    public Product findMaxPrice(){
        return productRepository.findMaxPrice();
    }
    public List<Product> findMinMaxPrice(){
        return productRepository.findMinMaxPrice();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
