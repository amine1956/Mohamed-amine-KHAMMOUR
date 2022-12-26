package com.example.mecro1.query;

import com.example.mecro1.query.entite.Customer;
import com.example.mecro1.query.queries.GetAllCustomer;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
    @RequestMapping("/query")
public class CustomerQueryController {
    private QueryGateway queryGateway;

    public CustomerQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    @GetMapping("/customers")

    public CompletableFuture<List<Customer>> getAllCustomer(){
        return  queryGateway.query(new GetAllCustomer(), ResponseTypes.multipleInstancesOf(Customer.class));
    }
}
