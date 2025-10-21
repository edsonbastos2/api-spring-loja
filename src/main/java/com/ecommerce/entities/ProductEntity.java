package com.ecommerce.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "tb_products_tags",
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "tag_id"}),
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<TagsEntity> tags;

    public ProductEntity() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<TagsEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagsEntity> tags) {
        this.tags = tags;
    }
}
