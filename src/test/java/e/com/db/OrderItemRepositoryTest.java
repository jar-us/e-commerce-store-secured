package e.com.db;

import e.com.db.entity.Customer;
import e.com.db.entity.Order;
import e.com.db.entity.OrderItem;
import e.com.db.entity.Product;
import e.com.db.repo.CustomerRepository;
import e.com.db.repo.OrderItemRepository;
import e.com.db.repo.OrderRepository;
import e.com.db.repo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class OrderItemRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    private OrderItem savedOrderItem = null;
    private Order order = null;
    private Product product = null;

    @BeforeEach
    public void setup() {
        Customer customer = new Customer();
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

        orderRepository.save(order);

        product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setStockQuantity(50);

        productRepository.save(product);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(5);
        orderItem.setPrice(BigDecimal.valueOf(10.99));

        savedOrderItem = orderItemRepository.save(orderItem);
    }


    @Test
    public void testCreateOrderItem() {
        assertNotNull(savedOrderItem.getId());
        assertEquals(savedOrderItem.getOrder().getId(), order.getId());
        assertEquals(savedOrderItem.getProduct().getId(), product.getId());
        assertEquals(savedOrderItem.getQuantity(), 5);
        assertEquals(savedOrderItem.getPrice(), BigDecimal.valueOf(10.99));
    }

    @Test
    public void testGetOrderItemById() {
        Optional<OrderItem> retrievedOrderItem = orderItemRepository.findById(savedOrderItem.getId());
        assertTrue(retrievedOrderItem.isPresent());
        assertEquals(savedOrderItem, retrievedOrderItem.get());
    }

    @Test
    public void testUpdateOrderItem() {
        savedOrderItem.setQuantity(10);
        savedOrderItem.setPrice(BigDecimal.valueOf(20.99));

        OrderItem updatedOrderItem = orderItemRepository.save(savedOrderItem);

        assertEquals(updatedOrderItem.getQuantity(), 10);
        assertEquals(updatedOrderItem.getPrice(), BigDecimal.valueOf(20.99));
    }


    @Test
    public void testDeleteOrderItem() {
        orderItemRepository.deleteById(savedOrderItem.getId());

        Optional<OrderItem> retrievedOrderItem = orderItemRepository.findById(savedOrderItem.getId());
        assertFalse(retrievedOrderItem.isPresent());
    }


    @Test
    public void testGetOrderItemsByOrderId() {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());

        assertNotNull(orderItems);
        assertEquals(orderItems.size(), 1);
        assertEquals(orderItems.get(0), savedOrderItem);
    }

    @Test
    public void testGetOrderItemsByProductId() {
        List<OrderItem> orderItems = orderItemRepository.findByProductId(product.getId());

        assertNotNull(orderItems);
        assertEquals(orderItems.size(), 1);
        assertEquals(orderItems.get(0), savedOrderItem);
    }


    @Test
    public void testGetOrderItemsByCustomerId() {
        List<OrderItem> orderItems = orderItemRepository.findByOrderCustomerId(savedOrderItem.getOrder().getCustomer().getId());

        assertNotNull(orderItems);
        assertEquals(orderItems.size(), 1);
        assertEquals(orderItems.get(0), savedOrderItem);
    }


    @Test
    public void testGetAllOrderItems() {
        Iterable<OrderItem> orderItems = orderItemRepository.findAll();

        List<OrderItem> orderItemList = StreamSupport.stream(orderItems.spliterator(), false).collect(Collectors.toList());

        assertNotNull(orderItemList);
        assertEquals(orderItemList.size(), 1);
        assertEquals(orderItemList.get(0), savedOrderItem);
    }


    @Test
    public void testGetOrderItemsByOrderDateRange() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(7);
        LocalDateTime endDate = LocalDateTime.now().plusDays(7);

        List<OrderItem> orderItems = orderItemRepository.findByOrderOrderDateBetween(startDate, endDate);

        assertNotNull(orderItems);
        assertEquals(orderItems.size(), 1);
        assertEquals(orderItems.get(0), savedOrderItem);
    }


    @Test
    public void testUpdateProduct() {
        Product newProduct = new Product();
        newProduct.setName("New Test Product");
        newProduct.setDescription("This is a new test product");
        newProduct.setPrice(BigDecimal.valueOf(15.99));
        newProduct.setStockQuantity(100);

        productRepository.save(newProduct);

        savedOrderItem.setProduct(newProduct);
        OrderItem updatedOrderItem = orderItemRepository.save(savedOrderItem);

        assertEquals(updatedOrderItem.getProduct(), newProduct);
    }


    @Test
    public void testCreateOrderItemWithZeroQuantity() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setPrice(BigDecimal.valueOf(10.99));

        Throwable exception = assertThrows(DataIntegrityViolationException.class, () -> orderItemRepository.save(orderItem));
        System.out.println("exception=" + exception.getMessage());
    }

}
