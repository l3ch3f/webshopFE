package com.webshoptg.assignment.repository;

import com.webshoptg.assignment.model.product.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long> {
    @Query("SELECT p FROM ProductInfo p WHERE p.productName = ?1")
    ProductInfo findByName(String productName);
}
