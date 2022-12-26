package com.example.mecro1.commandes.aggeregate;

import com.example.command.CreateCustomerCommand;
import com.example.command.UpdateCustomerCommand;
import com.example.event.CustomerCreatedEvent;
import com.example.event.CustomerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate

public class CustomerAgregete {

    @AggregateIdentifier
    private String id;
    private String name;
    private String email;
    private String phone;

    private String Address;

    public CustomerAgregete() {
    }

    @CommandHandler

    public CustomerAgregete(CreateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerCreatedEvent(command.getId(), command.getName(), command.getEmail(), command.getPhone(), command.getAddress()));
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
        this.Address = event.getAddress();
    }

    @CommandHandler
    public void on(UpdateCustomerCommand command) {
        if(command.getId() != null) {
            AggregateLifecycle.apply(new CustomerUpdatedEvent(command.getId(), command.getName(), command.getEmail(), command.getPhone(), command.getAddress()));
        }
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
        this.Address = event.getAddress();
    }

}
