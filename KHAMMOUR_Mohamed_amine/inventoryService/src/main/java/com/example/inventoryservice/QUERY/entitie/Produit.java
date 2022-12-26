package com.example.inventoryservice.QUERY.entitie;

import com.example.command.Etat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Produit {
    @Id
    private String id;
    private String name;
    private double price;
    private double quantite;
    private Etat etat;
    @ManyToOne
    private Category category;



}
