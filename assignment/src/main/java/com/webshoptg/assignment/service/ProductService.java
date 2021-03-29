package com.webshoptg.assignment.service;

import com.webshoptg.assignment.model.product.ProductInfo;
import com.webshoptg.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Query("SELECT p FROM ProductInfo p WHERE p.productName = ?1")
    public ProductInfo findByName(String productName) {
        return repository.findByName(productName);
    }

    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    public List<ProductInfo> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public List<ProductInfo> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    public <S extends ProductInfo> List<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    public void flush() {
        repository.flush();
    }

    public <S extends ProductInfo> S saveAndFlush(S s) {
        return repository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<ProductInfo> iterable) {
        repository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public ProductInfo getOne(Long aLong) {
        return repository.getOne(aLong);
    }

    public <S extends ProductInfo> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    public <S extends ProductInfo> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public <S extends ProductInfo> S save(S s) {
        return repository.save(s);
    }

    public Optional<ProductInfo> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void delete(ProductInfo productInfo) {
        repository.delete(productInfo);
    }

    public void deleteAll(Iterable<? extends ProductInfo> iterable) {
        repository.deleteAll(iterable);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public <S extends ProductInfo> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    public <S extends ProductInfo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    public <S extends ProductInfo> long count(Example<S> example) {
        return repository.count(example);
    }

    public <S extends ProductInfo> boolean exists(Example<S> example) {
        return repository.exists(example);
    }
}
