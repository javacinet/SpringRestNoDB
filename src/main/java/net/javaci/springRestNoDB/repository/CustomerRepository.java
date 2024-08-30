package net.javaci.springRestNoDB.repository;

import lombok.extern.slf4j.Slf4j;
import net.javaci.springRestNoDB.model.Customer;
import net.javaci.springRestNoDB.util.CustomerSortingOptions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public List<Customer> getAllPersons(CustomerSortingOptions sortingOptions) {
        // log.info("getAllCustomers is called in Repository");
        return new ArrayList<>(customers);
    }

    public Customer savePerson(Customer customer) {
        var optionalExistingPerson = customers.stream().filter(existingCustomer -> existingCustomer.getId().equals(customer.getId())).findFirst();
        return optionalExistingPerson
                .map(value -> updateCustomer(customer, value))
                .orElseGet(() -> addCustomer(customer));
    }

    private static Customer updateCustomer(Customer customer, Customer existingPerson) {
        existingPerson.setFirstName(customer.getFirstName());
        existingPerson.setLastName(customer.getLastName());
        existingPerson.setBirthday(customer.getBirthday());
        return existingPerson;
    }

    private Customer addCustomer(Customer customer) {
        customer.setId(UUID.randomUUID());
        customers.add(customer);
        return customer;
    }

    public void deletePerson(UUID personId) {
        customers.removeIf(customer -> customer.getId().equals(personId));
    }

    public Customer getPerson(UUID customerId) {
        return customers.stream().filter(c -> c.getId().equals(customerId)).findFirst().orElse(null);
    }
}
