package ru.geekbrains.persist.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")

        public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "familyName")
    private String familyName;

    @ManyToMany
    @JoinTable(
            name = "ties",
            joinColumns=@JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "productId")

)
    private List<Product> products;

    public Customer(){};
    public Customer(Integer id, String firstName, String familyName, List<Product> products){
        this.id=id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.products=products;
    }

    public Customer(String firstName, String familyName){

        this.firstName = firstName;
        this.familyName = familyName;
    }

    public Customer(Integer id, String firstName, String familyName){
        this.id=id;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public void setId(Integer id) { this.id = id; }
    public Integer getId() {
        return id;
    }


    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFamilyName(String family_name) {
        this.familyName = family_name;
    }
    public String getFamilyName() {
        return familyName;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", family_name='" + familyName + '\'' +
                '}'+   '\n';     // -добавим, чтобы разделять вывод
    }


}

