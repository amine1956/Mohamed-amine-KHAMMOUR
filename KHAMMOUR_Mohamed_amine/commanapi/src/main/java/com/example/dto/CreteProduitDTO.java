package com.example.dto;

import com.example.command.Etat;

public class CreteProduitDTO {
    private String name;
    private Etat etat;
    private String Idcategorie;
    private Double price ;
    private double quantite;

    public CreteProduitDTO(String name, Etat etat, String categorie, Double price, double quantite) {
        this.name = name;
        this.etat = etat;
        this.Idcategorie = categorie;
        this.price = price;
        this.quantite = quantite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Etat getEtat() {
        return etat;
    }

    public String getIdcategorie() {
        return Idcategorie;
    }

    public Double getPrice() {
        return price;
    }
    public double getQuantite() {
        return quantite;
    }
}

