package com.example.inventoryservice.command.aggergate;

import com.example.command.CreatProduitCommand;
import com.example.command.Etat;
import com.example.command.UpdateProduitCommand;
import com.example.event.ProduitCreatedEvent;
import com.example.event.ProduitUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProduitAgregate {
    @AggregateIdentifier

    private String id;
    private String name;
    private double price;
    private double quantity;
    private String categorieId;
    private Etat etat;

    public ProduitAgregate() {
    }
    @CommandHandler

    public ProduitAgregate(CreatProduitCommand command) {
        AggregateLifecycle.apply(new ProduitCreatedEvent(command.getId(), command.getName(), command.getPrice(), command.getQuantite(), command.getCategorieId(),command.getEtat()));
    }
    @EventSourcingHandler
    public void on(ProduitCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantite();
        this.categorieId = event.getIdcategorie();
    }

    @CommandHandler
    public void on(UpdateProduitCommand command) {
        if(command.getId() != null) {
            AggregateLifecycle.apply(new ProduitUpdatedEvent(command.getId(), command.getName(), command.getPrice(), command.getQuantite(), command.getCategorieId(),command.getEtat()));
        }
    }
    @EventSourcingHandler
    public void on(ProduitUpdatedEvent event) {
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantite();
        this.categorieId = event.getIdcategorie();
        this.etat = event.getEtat();
    }

}
