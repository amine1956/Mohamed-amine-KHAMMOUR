package com.example.command;

public class CreateCategorieCommand extends BaseCategorieCommand<String> {
    private String name;
    private String description;

    public CreateCategorieCommand(String id, String name, String description) {
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

