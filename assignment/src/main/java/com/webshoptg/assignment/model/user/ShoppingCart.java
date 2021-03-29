package com.webshoptg.assignment.model.user;

import com.webshoptg.assignment.model.product.ProductInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;


    @OneToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<ProductInfo> productInfos;

    // TODO addproduct werkt nog niet.
    public void addToList(ProductInfo addProduct) {
        if (productInfos == null) {
            productInfos = new ArrayList<ProductInfo>();
        }
        productInfos.add(addProduct);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfo) {
        this.productInfos = productInfo;
    }
}
