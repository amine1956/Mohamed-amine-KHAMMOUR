package com.example.command;

import lombok.Getter;

public class UpdateProduitCommand extends BaseProduitCommand<String> {
    @Getter  private String name;
    @Getter private  Double price;
    @Getter private  double quantite;
    @Getter private  String categorieId;
    @Getter private Etat etat;

    public UpdateProduitCommand(String id, String name, Double price, double quantite, String categorieId, Etat etat) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantite = quantite;
        this.categorieId = categorieId;
        this.etat = etat;
    }
}

