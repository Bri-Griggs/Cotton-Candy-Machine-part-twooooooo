package SpringProject.Spring.Color;

import jakarta.persistence.*;

@Entity
@Table(name = "color_names")
public class ColorName {
    @Id
    @SequenceGenerator(
            name = "color_sequence",
            sequenceName = "color_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "color_sequence"
    )
    private Long id;
    private String colorName;

    public ColorName() {}

    public ColorName(String colorName) {
        this.colorName = colorName;
    }

    public ColorName(Long id, String colorName) {
        this.id = id;
        this.colorName = colorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        return "ColorName{" +
                "id=" + id +
                ", colorName='" + colorName + '\'' +
                '}';
    }
}