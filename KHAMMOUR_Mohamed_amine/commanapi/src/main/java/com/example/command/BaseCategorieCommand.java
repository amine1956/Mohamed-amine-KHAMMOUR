package com.example.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCategorieCommand <T> {
    @TargetAggregateIdentifier
    @Getter
    public String id;

    public BaseCategorieCommand(String id) {
        this.id = id;
    }

}

