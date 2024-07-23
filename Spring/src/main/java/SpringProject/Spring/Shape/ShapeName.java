package SpringProject.Spring.Shape;


import jakarta.persistence.*;

@Entity
@Table
public class ShapeName {
    @Id
    @SequenceGenerator(
            name = "shape_sequence",
            sequenceName = "shape_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shape_sequence"
    )
    Long id;
    String shapeName;

    public ShapeName(){}

    public ShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public ShapeName(Long id, String shapeName) {
        this.id = id;
        this.shapeName = shapeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}