package ru.geekbrains.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.entity.Category;

import java.math.BigDecimal;

public final class CategorySpecificatiom {

    public static Specification<Category> trueLiteral() {
        return (root, query, builder) -> builder.isTrue(builder.literal(true));
    }

    public static Specification<Category> titleLike(String title) {
        return (root, query, builder) -> builder.like(root.get("category").get("title"), "%" + title + "%");
    }

    public static Specification<Category> idLike(Integer id) {
        return (root, query, builder) -> builder.equal(root.get("id"), id);
    }

    public static Specification<Category> priceGreaterThan(BigDecimal price) {
        return (root, query, builder) -> builder.ge(root.get("price"), price);
    }

    public static Specification<Category> priceLessThan(BigDecimal price) {
        return (root, query, builder) -> builder.lessThan(root.get("price"), price);
    }
}