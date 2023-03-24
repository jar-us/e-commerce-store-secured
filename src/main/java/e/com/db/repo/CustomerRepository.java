package e.com.db.repo;

import e.com.db.entity.Category;
import e.com.db.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

