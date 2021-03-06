package webshop.webshop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import webshop.webshop.model.user.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UsersRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UsersRepository repo;

    @Test
    public void testCreateProduct1() {
        User user = new User();
        user.setEmail("chen@gmail.com");
        user.setPassword("$2a$10$U6MN/dBhj0myRFKhYYKQKOImJJHNoFNQRn3NmVKn6cvwbM8ig14Wq");
        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

}