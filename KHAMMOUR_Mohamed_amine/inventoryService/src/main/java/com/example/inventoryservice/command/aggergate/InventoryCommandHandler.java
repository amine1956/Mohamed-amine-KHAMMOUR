package com.example.inventoryservice.command.aggergate;

import com.example.command.CreatProduitCommand;
import com.example.command.CreateCategorieCommand;
import com.example.dto.CreateCategorieDTO;
import com.example.dto.CreteProduitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
@RequestMapping("/command/inventory")
public class InventoryCommandHandler {
    private EventStore eventStore;
    private CommandGateway commandGateway;

    public InventoryCommandHandler(EventStore eventStore, CommandGateway commandGateway) {
        this.eventStore = eventStore;
        this.commandGateway = commandGateway;
    }


    @PostMapping("/createCategory")
    public CompletableFuture<String> createCategory(@RequestBody CreateCategorieDTO createCategorieDTO) {
        return commandGateway.send(new CreateCategorieCommand(UUID.randomUUID().toString(), createCategorieDTO.getName(), createCategorieDTO.getDescription()));
    }

    @PostMapping("/createProduct")
    public CompletableFuture<String> createProduct(@RequestBody CreteProduitDTO creteProduitDTO) {
        return commandGateway.send(new CreatProduitCommand(UUID.randomUUID().toString(), creteProduitDTO.getName(),creteProduitDTO.getPrice(), creteProduitDTO.getQuantite(), creteProduitDTO.getIdcategorie(), creteProduitDTO.getEtat()));
    }

}



