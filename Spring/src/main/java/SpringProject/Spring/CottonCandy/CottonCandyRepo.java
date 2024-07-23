package SpringProject.Spring.CottonCandy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottonCandyRepo extends JpaRepository<CottonCandy, Long> {
}
