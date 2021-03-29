package com.webshoptg.assignment.model.product;

import javax.persistence.*;

@Entity
@Table(name = "productInfo")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String productName;
    private String price;
    private String imgUrl;
    private String producer;
    private String description;

    @OneToOne (cascade=CascadeType.ALL)
    private ProductSpecification productSpecification;

    @OneToOne(cascade=CascadeType.ALL)
    private StockList stockList;

    // Constructors

    // Getters and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }

    public StockList getStockList() {
        return stockList;
    }

    public void setStockList(StockList stockList) {
        this.stockList = stockList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
