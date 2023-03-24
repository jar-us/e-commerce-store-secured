package e.com.db.repo;

import e.com.db.entity.Category;
import e.com.db.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findByNameContainingIgnoreCase(String test);

    List<Product> findByPriceBetween(BigDecimal valueOf, BigDecimal valueOf1);
}

