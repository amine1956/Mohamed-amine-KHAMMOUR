package com.example.mecro1.query.service;

import com.example.event.CustomerCreatedEvent;
import com.example.mecro1.query.entite.Customer;
import com.example.mecro1.query.queries.GetAllCustomer;
import com.example.mecro1.query.reposetories.CustomerRepesetory;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerEventHandlerService {
    private CustomerRepesetory customerRepesetory;

    public CustomerEventHandlerService(CustomerRepesetory customerRepesetory) {
        this.customerRepesetory = customerRepesetory;
    }
    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("********************************", event);
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customer.setAddress(event.getAddress());
        customerRepesetory.save(customer);
    }
    @QueryHandler
    public List<Customer> on(GetAllCustomer query){
        return customerRepesetory.findAll();
    }

}
