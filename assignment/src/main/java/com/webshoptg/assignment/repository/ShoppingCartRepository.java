package com.webshoptg.assignment.repository;

import com.webshoptg.assignment.model.product.ProductInfo;
import com.webshoptg.assignment.model.user.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("SELECT t FROM ShoppingCart t WHERE t.token = ?1")
    ShoppingCart findByToken(String token);
}
