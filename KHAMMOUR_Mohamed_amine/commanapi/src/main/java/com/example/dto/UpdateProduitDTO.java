package com.example.dto;

public class UpdateProduitDTO {
    private String name;
    private String description;
    private String etat;
    private String Idcategorie;

    private Double price ;
    private double quantite;

    public UpdateProduitDTO(String name, String description, String etat, String categorie, Double price, double quantite) {
        this.name = name;
        this.description = description;
        this.etat = etat;
        this.Idcategorie = categorie;
        this.price = price;
        this.quantite = quantite;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
    }

    public String getIdcategorie() {
        return Idcategorie;
    }
}

