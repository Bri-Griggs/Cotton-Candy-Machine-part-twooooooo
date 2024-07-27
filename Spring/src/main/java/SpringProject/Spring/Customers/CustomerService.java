package SpringProject.Spring.Customers;

import SpringProject.Spring.CottonCandy.CottonCandy;
import SpringProject.Spring.CottonCandy.CottonCandyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CottonCandyRepo CottonCandyRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo, CottonCandyRepo CottonCandyRepo) {
        this.customerRepo = customerRepo;
        this.CottonCandyRepo = CottonCandyRepo;
    }

    public List<CustomerName> getAllCustomers() {
        return customerRepo.findAll();
    }

    public CustomerName getCustomer(Long id) {
        return customerRepo.findById(id).orElseThrow(() -> new IllegalStateException("Customer not found"));
    }

    public void addCustomer(CustomerName newCustomer) {
        customerRepo.save(newCustomer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Customer not found");
        }
        customerRepo.deleteById(id);
    }

    @Transactional
    public void updateCustomer(Long id, String name) {
        CustomerName customerInstance = customerRepo.findById(id).orElseThrow(() -> new IllegalStateException("Customer not found!"));
        if (name != null && !name.isEmpty() && !Objects.equals(customerInstance.getCustomerName(), name)) {
            customerInstance.setCustomerName(name);
        }
    }
}
