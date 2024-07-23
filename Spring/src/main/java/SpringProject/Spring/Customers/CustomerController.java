package SpringProject.Spring.Customers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public List<CustomerName> getCustomers(){
        return customerService.getAllCustomers();
    }

    public void postCustomer(CustomerName newCustomer){
        customerService.addCustomer(newCustomer);
    }

    public void delCustomer(Long id){
        customerService.deleteCustomer(id);
    }

    public void putCustomer(Long id, String newName){
        customerService.updateCustomer(id, newName);
    }
}
