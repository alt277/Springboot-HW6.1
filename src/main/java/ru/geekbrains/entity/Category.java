package ru.geekbrains.entity;


import com.fasterxml.jackson.annotation.JsonView;
import ru.geekbrains.entity.views.CategoryView;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonView(CategoryView.CategoryId.class)
    Integer id;

    @Column(name = "title")
    @JsonView(CategoryView.WholeCategory.class)
    String title;

    @OneToMany(mappedBy = "category")
    List<Product> productList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
