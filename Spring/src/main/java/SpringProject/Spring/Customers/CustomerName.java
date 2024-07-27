package SpringProject.Spring.Customers;

import SpringProject.Spring.CottonCandy.CottonCandy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_names")
public class CustomerName {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;

    private String customerName;

    @ManyToMany(mappedBy = "customers")
    @JsonIgnore
    private Set<CottonCandy> cottonCandies;

    public CustomerName() {}

    public CustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerName(Long id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<CottonCandy> getCottonCandies() {
        return cottonCandies;
    }

    public void setCottonCandies(Set<CottonCandy> cottonCandies) {
        this.cottonCandies = cottonCandies;
    }

    @Override
    public String toString() {
        return "CustomerName{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}