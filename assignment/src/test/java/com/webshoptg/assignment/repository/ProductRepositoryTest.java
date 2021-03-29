package com.webshoptg.assignment.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.webshoptg.assignment.model.product.ProductInfo;
import com.webshoptg.assignment.model.product.ProductSpecification;
import com.webshoptg.assignment.model.product.StockList;
import com.webshoptg.assignment.model.user.ShoppingCart;
import com.webshoptg.assignment.model.user.UserLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ProductRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductRepository repo;
    @Autowired
    private TokenRepository token;
    @Autowired
    private ShoppingCartRepository shop;

    @Test
    public void testRepoCart(){
        ShoppingCart cart = new ShoppingCart();
        shop.save(cart);
    }
    @Test
    public void testRepoToken(){
        UserLog log = new UserLog();
        token.save(log);
    }
    @Test
    public void testCreateProduct1(){

        ProductInfo productInfo = new ProductInfo();
        ProductSpecification specs = new ProductSpecification();
        StockList stock = new StockList();
        productInfo.setProductName("Acer Aspire 5 A515-44-R0F5 - Laptop - 15.6 Inch");
        productInfo.setProducer("Acer");
        productInfo.setProductSpecification(specs);
        productInfo.setStockList(stock);
        productInfo.setPrice("679");
        productInfo.setImgUrl("https://media.s-bol.com/6B6w0L9ngVE7/124x89.jpg");
        productInfo.setDescription("Deze Acer laptop is geschikt voor het bekijken van je favoriete films en series. Dankzij het IPS scherm heb je een brede kijkhoek en een realistische kleurweergave, ideaal voor grafisch design. Deze laptop is razendsnel dankzij de snelle processor en SSD.");
        stock.setStockQuantity(12);
        specs.setCodename("ZEN");
        specs.setProductModel("12");
        specs.setInternMemory("32RAM");
        specs.setProcessorType("I7");
        specs.setType("AMD Ryzen 5");
        specs.setGraphicCard("AMD Radeon Graphics");
        specs.setScreenSize("1920x1080");
        ProductInfo savedProduct = repo.save(productInfo);
        ProductInfo existProduct = entityManager.find(ProductInfo.class, savedProduct.getId());
        assertThat(productInfo.getProductName()).isEqualTo(existProduct.getProductName());
    }

    @Test
    public void testCreateProduct2(){
        ProductInfo productInfo = new ProductInfo();
        ProductSpecification specs = new ProductSpecification();
        StockList stock = new StockList();
        productInfo.setProductName("TEST Aspire 5 A515-44-R0F5 - Laptop - 15.6 Inch");
        productInfo.setProducer("Acer");
        productInfo.setProductSpecification(specs);
        productInfo.setStockList(stock);
        productInfo.setPrice("679");
        productInfo.setImgUrl("https://media.s-bol.com/YMVLWLO38gvA/168x92.jpg");
        productInfo.setDescription("Deze Acer laptop is geschikt voor het bekijken van je favoriete films en series. Dankzij het IPS scherm heb je een brede kijkhoek en een realistische kleurweergave, ideaal voor grafisch design. Deze laptop is razendsnel dankzij de snelle processor en SSD.");
        stock.setStockQuantity(12);
        specs.setCodename("ZEN");
        specs.setProductModel("12");
        specs.setInternMemory("32RAM");
        specs.setProcessorType("I7");
        specs.setType("AMD Ryzen 5");
        specs.setGraphicCard("AMD Radeon Graphics");
        specs.setScreenSize("1920x1080");
        ProductInfo savedProduct = repo.save(productInfo);
        ProductInfo existProduct = entityManager.find(ProductInfo.class, savedProduct.getId());
        assertThat(productInfo.getProductName()).isEqualTo(existProduct.getProductName());
    }

    @Test
    public void testCreateProduct3(){
        ProductInfo productInfo = new ProductInfo();
        ProductSpecification specs = new ProductSpecification();
        StockList stock = new StockList();
        productInfo.setProductName("ASUS VivoBook 15 M513IA-BQ452T - Laptop - 15.6 inch");
        productInfo.setProducer("Acer");
        productInfo.setProductSpecification(specs);
        productInfo.setStockList(stock);
        productInfo.setPrice("1679");
        productInfo.setImgUrl("https://media.s-bol.com/mEXlYPzoX3on/168x122.jpg");
        productInfo.setDescription("Deze Acer laptop is geschikt voor het bekijken van je favoriete films en series. Dankzij het IPS scherm heb je een brede kijkhoek en een realistische kleurweergave, ideaal voor grafisch design. Deze laptop is razendsnel dankzij de snelle processor en SSD.");
        stock.setStockQuantity(12);
        specs.setCodename("ZEN");
        specs.setProductModel("12");
        specs.setInternMemory("32RAM");
        specs.setProcessorType("I7");
        specs.setType("AMD ");
        specs.setGraphicCard("GEFORCEX123");
        specs.setScreenSize("1920x1080");
        ProductInfo savedProduct = repo.save(productInfo);
        ProductInfo existProduct = entityManager.find(ProductInfo.class, savedProduct.getId());
        assertThat(productInfo.getProductName()).isEqualTo(existProduct.getProductName());
    }
}