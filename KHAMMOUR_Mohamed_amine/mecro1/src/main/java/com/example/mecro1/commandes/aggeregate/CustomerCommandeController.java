package com.example.mecro1.commandes.aggeregate;

import com.example.command.CreateCustomerCommand;
import com.example.dto.CreateCustomerDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/customer")
public class CustomerCommandeController {
    private EventStore eventStore;
    private CommandGateway commandGateway;

    public CustomerCommandeController(EventStore eventStore, CommandGateway commandGateway) {
        this.eventStore = eventStore;
        this.commandGateway = commandGateway;
    }

    @GetMapping("/eventsStore/{id}")
    public Stream getEventsStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }
    
    @PostMapping("/create")
    public CompletableFuture<String> Customer(@RequestBody CreateCustomerDTO createCustomerDTO){
        return commandGateway.send(new CreateCustomerCommand(UUID.randomUUID().toString(), createCustomerDTO.getName(), createCustomerDTO.getEmail(), createCustomerDTO.getPhone(), createCustomerDTO.getAddress()));
    }

}
