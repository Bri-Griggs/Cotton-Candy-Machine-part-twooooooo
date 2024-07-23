package SpringProject.Spring.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<CustomerName> getAllCustomers() {
        return customerRepo.findAll();
    }

    public void addCustomer(CustomerName customer) {
        customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Customer not found");
        }
        customerRepo.deleteById(id);
    }
    public void updateCustomer(Long id, String name) {
        CustomerName customerInstance = customerRepo.findById(id).orElseThrow(() -> new IllegalStateException("Customer not found!"));
        if (name != null && !name.isEmpty() && !Objects.equals(customerInstance.getCustomerName(), name)) {
            customerInstance.setCustomerName(name);
        }
    }
    }
