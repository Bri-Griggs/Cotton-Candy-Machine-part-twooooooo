package SpringProject.Spring.CottonCandy;

import SpringProject.Spring.Color.ColorName;
import SpringProject.Spring.Customers.CustomerName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table

public class CottonCandy {
    @Id
    @SequenceGenerator(
            name = "cottonCandy_sequence",
            sequenceName = "cottonCandy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cottonCandy_sequence"
    )

    private Long id;
    private String color;
    @OneToMany(mappedBy = "cottonCandy")
    @JsonIgnore
    private List<ColorName> colors;
    @ManyToMany(mappedBy = "cottonCandies")
    private Set<CustomerName> customers;

    public CottonCandy() {}

    public CottonCandy(String color, List<ColorName> shape, Set<CustomerName> customers) {
        this.color = color;
        this.colors = shape;
        this.customers = customers;
    }

    public CottonCandy(Long id, String color, List<ColorName> shape, Set<CustomerName> customers) {
        this.id = id;
        this.color = color;
        this.colors = shape;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<ColorName> getShape() {
        return colors;
    }

    public void setShape(List<ColorName> shape) {
        this.colors = shape;
    }

    public List<ColorName> getColors() {
        return colors;
    }

    public void setColors(List<ColorName> colors) {
        this.colors = colors;
    }

    public Set<CustomerName> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerName> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CottonCandy{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", colors=" + colors +
                ", customers=" + customers +
                '}';
    }
}
