package com.example.inventoryservice.command.aggergate;

import com.example.command.CreateCategorieCommand;
import com.example.command.UpdateCategorieCommand;
import com.example.event.CategorieCreatedEvent;
import com.example.event.CategorieUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate

public class CategorieAgregate {
      @AggregateIdentifier
       private String id;
      private String name;
        private String description;
        public CategorieAgregate() {
        }
        @CommandHandler
        public CategorieAgregate(CreateCategorieCommand command) {
            AggregateLifecycle.apply(new CategorieCreatedEvent(command.getId(), command.getName(), command.getDescription()));
        }
        @EventSourcingHandler
        public void on(CategorieCreatedEvent event) {
            this.id = event.getId();
            this.name = event.getName();
            this.description = event.getDescription();
        }
        @CommandHandler
        public void on(UpdateCategorieCommand command) {
            if(command.getId() != null) {
                AggregateLifecycle.apply(new CategorieUpdatedEvent(command.getId(), command.getName(), command.getDescription()));
            }
        }
        @EventSourcingHandler
        public void on(CategorieUpdatedEvent event) {
            this.name = event.getName();
            this.description = event.getDescription();
        }


}
