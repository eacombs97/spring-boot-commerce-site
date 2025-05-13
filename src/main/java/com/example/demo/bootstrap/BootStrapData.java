package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** BootStrapData.java
 *
 * @author Emily Combs
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        // Check if "David Rowe" exists in the database to determine if run before
        boolean namesExists = customerRepository.findAll().stream()
                .anyMatch(c -> c.getFirstName().equals("David") && c.getLastName().equals("Rowe"));
        if (!namesExists) {
            //add sample data
            //Random for division id
            Random random = new Random();
            //List for customers for saving
            List<Customer> customers = new ArrayList<>();

            // List of realistic names and data for customers
            String[] firstNames = {"Jeremy", "Donald", "Mickey", "Emily", "David"};
            String[] lastNames = {"Johnson", "Duck", "Mouse", "Brown", "Rowe"};
            String[] addresses = {
                    "123 Main Street",
                    "456 Oak Avenue",
                    "789 Pine Road",
                    "111 Maple Drive",
                    "222 Sesame Street"
            };
            String[] postalCodes = {"62701", "62702", "80202", "73301", "98101"};
            String[] phones = {"(217)555-1234", "(217)555-5678", "(303)555-7890", "(512)555-1011", "(206)555-2345"};


            // Creating 5 customers with real data
            for (int i = 0; i < 5; i++) {  // Creating 5 customers
                Customer customer = new Customer();
                customer.setFirstName(firstNames[i]);
                customer.setLastName(lastNames[i]);
                customer.setAddress(addresses[i]);
                customer.setPostal_code(postalCodes[i]);
                customer.setPhone(phones[i]);
                customer.setDivision(divisionRepository.findById(getRandomDivision(random)).get());
                customers.add(customer);
            }

            // Save all customers to the repository
            customerRepository.saveAll(customers);
        }
    }

    private Long getRandomDivision(Random random) {
        if (random.nextBoolean()) {
            return 2L + random.nextInt(71); // 2–72
        } else {
            return 101L + random.nextInt(4); // 101–104
        }
    }
}
