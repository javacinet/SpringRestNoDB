package net.javaci.springRestNoDB.controller;

import net.javaci.springRestNoDB.model.Customer;
import net.javaci.springRestNoDB.service.CustomerService;
import net.javaci.springRestNoDB.util.CustomerSortingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(value = "sortField", defaultValue = "ID") CustomerSortingOptions.SortField sortField,
                                                          @RequestParam(value = "sortingOrder", defaultValue = "ASCENDING") CustomerSortingOptions.SortingOrder sortingOrder) {
        return ResponseEntity.ok(customerService.getAllPersons(new CustomerSortingOptions(sortingOrder, sortField)));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer>  getCustomer(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getPerson(customerId));
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (customer.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.savePerson(customer));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable("customerId") UUID customerId) {
        if (updatedCustomer.getId() == null || !updatedCustomer.getId().equals(customerId)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.savePerson(updatedCustomer));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deletePerson(customerId);
        return ResponseEntity.noContent().build();
    }
}
