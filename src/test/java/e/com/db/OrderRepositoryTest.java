package e.com.db;

import e.com.db.entity.Category;
import e.com.db.entity.Customer;
import e.com.db.entity.Order;
import e.com.db.entity.Product;
import e.com.db.repo.CategoryRepository;
import e.com.db.repo.CustomerRepository;
import e.com.db.repo.OrderRepository;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    private Customer customer = null;
    private Order order = null;
    private Order savedOrder = null;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAddress("123 Main St");
        customer.setCity("Anytown");
        customer.setCountry("USA");

        customerRepository.save(customer);

        order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(BigDecimal.valueOf(100.00));
        order.setStatus("Pending");

        savedOrder = orderRepository.save(order);
    }

    @Test
    public void testCreateOrder() {
        assertNotNull(savedOrder.getId());
        assertEquals(customer.getId(), savedOrder.getCustomer().getId());
        assertEquals(order.getOrderDate(), savedOrder.getOrderDate());
        assertEquals(order.getTotalAmount(), savedOrder.getTotalAmount());
        assertEquals(order.getStatus(), savedOrder.getStatus());
    }

    @Test
    public void testGetOrderById() {
        Optional<Order> retrievedOrder = orderRepository.findById(savedOrder.getId());
        assertTrue(retrievedOrder.isPresent());
        assertEquals(savedOrder, retrievedOrder.get());
    }

    @Test
    public void testUpdateOrder() {
        savedOrder.setTotalAmount(BigDecimal.valueOf(200.00));
        savedOrder.setStatus("Completed");
        Order updatedOrder = orderRepository.save(savedOrder);
        assertEquals(savedOrder.getId(), updatedOrder.getId());
        assertEquals(BigDecimal.valueOf(200.00), updatedOrder.getTotalAmount());
        assertEquals("Completed", updatedOrder.getStatus());
    }

    @Test
    public void testDeleteOrder() {
        orderRepository.deleteById(savedOrder.getId());
        assertFalse(orderRepository.findById(savedOrder.getId()).isPresent());
    }
}
