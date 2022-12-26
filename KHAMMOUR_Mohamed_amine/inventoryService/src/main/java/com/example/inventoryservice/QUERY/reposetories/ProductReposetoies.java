package com.example.inventoryservice.QUERY.reposetories;

import com.example.inventoryservice.QUERY.entitie.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposetoies extends JpaRepository<Produit, String> {
}

