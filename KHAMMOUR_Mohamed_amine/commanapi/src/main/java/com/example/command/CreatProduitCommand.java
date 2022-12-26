package com.example.command;

import lombok.Getter;

public class CreatProduitCommand extends BaseProduitCommand<String> {
    @Getter  private String name;
    @Getter private  double price;
    @Getter private  double quantite;
    @Getter private  String categorieId;
    @Getter private Etat etat;

    public CreatProduitCommand(String id, String name, double price, double quantite, String categorieId, Etat etat) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantite = quantite;
        this.categorieId = categorieId;
        this.etat = etat;
    }
}

