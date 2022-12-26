package com.example.command;

public class BaseProduitCommand <T>{
    public  T id;

    public BaseProduitCommand(T id) {
        this.id = id;
    }
    public T getId() {
        return id;
    }


}
