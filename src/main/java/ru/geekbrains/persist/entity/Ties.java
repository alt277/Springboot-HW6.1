package ru.geekbrains.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ties")
public class Ties {
    @Id
    @Column
    private Integer id;

    @Column
    private Integer productId;

    @Column
    private Integer customerId;

    public Ties() {
    }


    public Ties(Integer id, Integer customerId, Integer productId) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customer_id) {
        this.customerId = customer_id;
    }

    public Integer getProductId() { return productId; }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
    }

    @Override
    public String toString() {
        return "Ties{" +
                "id=" + id +
                ", product_id=" + productId +
                ", customer_id=" + customerId +
                '}';
    }
}
