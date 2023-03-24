package e.com.db;

import e.com.db.entity.Category;
import e.com.db.entity.Product;
import e.com.db.repo.CategoryRepository;
import e.com.db.repo.ProductRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    private Category category = null;

    private Product product = null;

    private Product savedProduct = null;

    private Product product1 = null;

    private Product product2 = null;

    @BeforeEach
    public void setup() {
        category = new Category(null, "Test Category");
        categoryRepository.save(category);

        product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setStockQuantity(50);
        product.setCategory(category);

        savedProduct = productRepository.save(product);

        product1 = new Product();
        product1.setName("Test Product 1");
        product1.setDescription("This is a test product");
        product1.setPrice(BigDecimal.valueOf(10.99));
        product1.setStockQuantity(50);
        product1.setCategory(category);

        product2 = new Product();
        product2.setName("Test Product 2");
        product2.setDescription("This is another test product");
        product2.setPrice(BigDecimal.valueOf(20.99));
        product2.setStockQuantity(100);
        product2.setCategory(category);

        productRepository.save(product1);
        productRepository.save(product2);
    }

    @Test
    public void testCreateProduct() {
        assertNotNull(savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getDescription(), savedProduct.getDescription());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStockQuantity(), savedProduct.getStockQuantity());
        assertEquals(product.getCategory().getId(), savedProduct.getCategory().getId());
    }

    @Test
    public void testGetAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        List<Product> productsStream = StreamSupport.stream(products.spliterator(), false).collect(Collectors.toList());
        assertNotNull(productsStream);
        assertFalse(productsStream.isEmpty());
    }

    @Test
    public void testGetProductsByCategory() {
        List<Product> products = productRepository.findByCategory(category);
        assertNotNull(products);
        assertEquals(3, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }

    @Test
    public void testGetProductsByName() {
        List<Product> products = productRepository.findByNameContainingIgnoreCase("test");
        assertNotNull(products);
        assertEquals(3, products.size());
        assertTrue(products.contains(product1));
        assertTrue(products.contains(product2));
    }

    @Test
    public void testGetProductsByPriceRange() {
        List<Product> products = productRepository.findByPriceBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(15));
        assertNotNull(products);
        MatcherAssert.assertThat(products, Matchers.hasSize(greaterThan(0)));
        assertTrue(products.contains(product1));
    }
}
