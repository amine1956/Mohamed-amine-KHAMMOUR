package com.example.event;

import com.example.command.Etat;

public class ProduitUpdatedEvent extends BaseEventProduit<String> {

    public  String name;
    public  Etat etat;

    public  String Idcategorie;

    private double quantite;

    private Double price ;





    public ProduitUpdatedEvent(String id, String name, Double price, double quantite, String categorieId, Etat etat) {
        super(id);
        this.name = name;
        this.etat = etat;
        this.quantite = quantite;
        this.price = price;
    }

    public String getName() {
        return name;
    }



    public Etat getEtat() {
        return etat;
    }

    public String getIdcategorie() {
        return Idcategorie;
    }

    public double getQuantite() {
        return quantite;
    }

    public Double getPrice() {
        return price;
    }
}

