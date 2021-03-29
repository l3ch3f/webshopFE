package webshop.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import webshop.webshop.model.user.User;
import webshop.webshop.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserService {
   @Autowired
   private UsersRepository repo;

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public List<User> findAll(Sort sort) {
        return repo.findAll(sort);
    }

    public List<User> findAllById(Iterable<Long> iterable) {
        return repo.findAllById(iterable);
    }

    public <S extends User> List<S> saveAll(Iterable<S> iterable) {
        return repo.saveAll(iterable);
    }

    public void flush() {
        repo.flush();
    }

    public <S extends User> S saveAndFlush(S s) {
        return repo.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<User> iterable) {
        repo.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        repo.deleteAllInBatch();
    }

    public User getOne(Long aLong) {
        return repo.getOne(aLong);
    }

    public <S extends User> List<S> findAll(Example<S> example) {
        return repo.findAll(example);
    }

    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return repo.findAll(example, sort);
    }

    public Page<User> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public <S extends User> S save(S s) {
        return repo.save(s);
    }

    public Optional<User> findById(Long aLong) {
        return repo.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return repo.existsById(aLong);
    }

    public long count() {
        return repo.count();
    }

    public void deleteById(Long aLong) {
        repo.deleteById(aLong);
    }

    public void delete(User user) {
        repo.delete(user);
    }

    public void deleteAll(Iterable<? extends User> iterable) {
        repo.deleteAll(iterable);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public <S extends User> Optional<S> findOne(Example<S> example) {
        return repo.findOne(example);
    }

    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repo.findAll(example, pageable);
    }

    public <S extends User> long count(Example<S> example) {
        return repo.count(example);
    }

    public <S extends User> boolean exists(Example<S> example) {
        return repo.exists(example);
    }
}
