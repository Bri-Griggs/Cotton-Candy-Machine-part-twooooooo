package SpringProject.Spring.Customers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "getcustomer")
    public List<CustomerName> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "getcustomer/{id}")
    public CustomerName getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping(path = "createnewcustomer")
    public void postCustomer(@RequestBody CustomerName newCustomer){
        customerService.addCustomer(newCustomer);
    }

    @DeleteMapping(path = "delcustomer/{id}")
    public void delCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "putcustomer/{id}")
    public void putCustomer(@PathVariable("id") Long id
            ,@RequestParam(required = false) String newName){
        customerService.updateCustomer(id, newName);
    }
}
