package com.webshoptg.assignment.repository;

import com.webshoptg.assignment.model.product.ProductInfo;
import com.webshoptg.assignment.model.user.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<UserLog, Long> {
}
