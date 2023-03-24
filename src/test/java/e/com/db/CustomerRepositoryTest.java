package e.com.db;

import e.com.db.entity.Category;
import e.com.db.entity.Customer;
import e.com.db.entity.Product;
import e.com.db.repo.CategoryRepository;
import e.com.db.repo.CustomerRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer = null;
    private Customer savedCustomer = null;


    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("johndoe@example.com");
        customer.setAddress("123 Main St");
        customer.setCity("Anytown");
        customer.setCountry("USA");

        savedCustomer = customerRepository.save(customer);
    }

    @Test
    public void testCreateCustomer() {
        assertNotNull(savedCustomer.getId());
        assertEquals(customer.getFirstName(), savedCustomer.getFirstName());
        assertEquals(customer.getLastName(), savedCustomer.getLastName());
        assertEquals(customer.getEmail(), savedCustomer.getEmail());
        assertEquals(customer.getAddress(), savedCustomer.getAddress());
        assertEquals(customer.getCity(), savedCustomer.getCity());
        assertEquals(customer.getCountry(), savedCustomer.getCountry());
    }

    @Test
    public void testGetCustomerById() {
        Optional<Customer> retrievedCustomer = customerRepository.findById(savedCustomer.getId());
        assertTrue(retrievedCustomer.isPresent());
        assertEquals(savedCustomer, retrievedCustomer.get());
    }

    @Test
    public void testUpdateCustomer() {
        savedCustomer.setFirstName("Jane");
        savedCustomer.setLastName("Smith");
        savedCustomer.setEmail("janesmith@example.com");
        savedCustomer.setAddress("456 Oak St");
        savedCustomer.setCity("Othertown");
        savedCustomer.setCountry("USA");

        Customer updatedCustomer = customerRepository.save(savedCustomer);

        assertEquals(savedCustomer.getId(), updatedCustomer.getId());
        assertEquals("Jane", updatedCustomer.getFirstName());
        assertEquals("Smith", updatedCustomer.getLastName());
        assertEquals("janesmith@example.com", updatedCustomer.getEmail());
        assertEquals("456 Oak St", updatedCustomer.getAddress());
        assertEquals("Othertown", updatedCustomer.getCity());
        assertEquals("USA", updatedCustomer.getCountry());
    }

    @Test
    public void testDeleteCustomer() {
        customerRepository.deleteById(savedCustomer.getId());
        assertFalse(customerRepository.findById(savedCustomer.getId()).isPresent());
    }
}
