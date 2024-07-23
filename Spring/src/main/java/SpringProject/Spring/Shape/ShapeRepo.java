package SpringProject.Spring.Shape;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeRepo extends JpaRepository<ShapeName, Long> {
}
