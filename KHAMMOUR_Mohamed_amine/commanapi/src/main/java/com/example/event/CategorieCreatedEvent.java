package com.example.event;

public class CategorieCreatedEvent extends BaseEventCategorie<String> {

    public final String name;
    public final String description;

    public CategorieCreatedEvent(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
