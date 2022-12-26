package com.example.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCustomerCommand <T> {
    @TargetAggregateIdentifier
    @Getter
    public final String id;

    public BaseCustomerCommand(String id) {
        this.id = id;
    }
}

