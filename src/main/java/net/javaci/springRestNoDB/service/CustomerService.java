package net.javaci.springRestNoDB.service;

import net.javaci.springRestNoDB.model.Customer;
import net.javaci.springRestNoDB.repository.CustomerRepository;
import net.javaci.springRestNoDB.util.CustomerSortingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static net.javaci.springRestNoDB.util.CustomerSortingOptions.SortingOrder.ASCENDING;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllPersons(CustomerSortingOptions sortingOptions) {
        List<Customer> customers = repository.getAllPersons(sortingOptions);

        if (sortingOptions == null) {
            return customers;
        }

        return sort(sortingOptions, customers);
    }

    private static ArrayList<Customer> sort(CustomerSortingOptions sortingOptions, List<Customer> customers) {
        var sortedList = new ArrayList<>(customers);
        sortedList.sort((p1, p2) -> {
            Customer customer1;
            Customer customer2;
            if (sortingOptions.getSortingOrder() == ASCENDING) {
                customer1 = p1;
                customer2 = p2;
            } else {
                customer1 = p2;
                customer2 = p1;
            }

            return switch (sortingOptions.getSortField()) {
                case ID -> customer1.getId().compareTo(customer2.getId());
                case FIRST_NAME -> customer1.getFirstName().compareTo(customer2.getFirstName());
                case LAST_NAME -> customer1.getLastName().compareTo(customer2.getLastName());
                case BIRTHDAY -> customer1.getBirthday().compareTo(customer2.getBirthday());
            };
        });
        return sortedList;
    }

    public Customer getPerson(UUID customerId) {
        return repository.getPerson(customerId);
    }

    public Customer savePerson(Customer customer) {
        return repository.savePerson(customer);
    }

    public void deletePerson(UUID personId) {
        repository.deletePerson(personId);
    }
}
