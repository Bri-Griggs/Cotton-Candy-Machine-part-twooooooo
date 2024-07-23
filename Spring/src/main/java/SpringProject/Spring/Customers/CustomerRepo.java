package SpringProject.Spring.Customers;

import SpringProject.Spring.CottonCandy.CottonCandy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerName, Long>{
}
