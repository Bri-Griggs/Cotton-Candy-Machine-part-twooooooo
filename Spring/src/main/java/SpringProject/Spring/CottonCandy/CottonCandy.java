package SpringProject.Spring.CottonCandy;

import SpringProject.Spring.Color.ColorName;
import SpringProject.Spring.Customers.CustomerName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cotton_candies")
public class CottonCandy {
    @Id
    @SequenceGenerator(
            name = "cotton_candy_sequence",
            sequenceName = "cotton_candy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cotton_candy_sequence"
    )
    private Long id;
    private String shape;

    @ManyToMany
    @JoinTable(
            name = "cotton_candy_customers",
            joinColumns = @JoinColumn(name = "cotton_candy_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<CustomerName> customers;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorName color;

    public CottonCandy() {}

    public CottonCandy(String shape, Set<CustomerName> customers, ColorName color) {
        this.shape = shape;
        this.customers = customers;
        this.color = color;
    }

    public CottonCandy(Long id, String shape, Set<CustomerName> customers, ColorName color) {
        this.id = id;
        this.shape = shape;
        this.customers = customers;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Set<CustomerName> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerName> customers) {
        this.customers = customers;
    }

    public ColorName getColor() {
        return color;
    }

    public void setColor(ColorName color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CottonCandy{" +
                "id=" + id +
                ", shape='" + shape + '\'' +
                ", customers=" + customers +
                ", color=" + color +
                '}';
    }
}