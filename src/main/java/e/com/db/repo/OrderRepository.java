package e.com.db.repo;

import e.com.db.entity.Category;
import e.com.db.entity.Order;
import e.com.db.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {


}

