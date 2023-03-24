package e.com.db.repo;

import e.com.db.entity.Category;
import e.com.db.entity.Order;
import e.com.db.entity.OrderItem;
import e.com.db.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);

    List<OrderItem> findByOrderId(Long id);

    List<OrderItem> findByProductId(Long id);

    List<OrderItem> findByOrderCustomerId(Long id);

    List<OrderItem> findByOrderOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}

