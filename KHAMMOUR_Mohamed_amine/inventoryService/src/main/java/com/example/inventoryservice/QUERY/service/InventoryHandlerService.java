package com.example.inventoryservice.QUERY.service;

import com.example.event.CategorieCreatedEvent;
import com.example.event.ProduitCreatedEvent;
import com.example.inventoryservice.QUERY.entitie.Category;
import com.example.inventoryservice.QUERY.entitie.Produit;
import com.example.inventoryservice.QUERY.queries.GetAllProduit;
import com.example.inventoryservice.QUERY.reposetories.CategorieReposetory;
import com.example.inventoryservice.QUERY.reposetories.ProductReposetoies;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class InventoryHandlerService {
    private ProductReposetoies productReposetoies;
    private CategorieReposetory categorieReposetory;

    public InventoryHandlerService(ProductReposetoies productReposetoies, CategorieReposetory categorieReposetory) {
        this.productReposetoies = productReposetoies;
        this.categorieReposetory = categorieReposetory;
    }
    @EventHandler
    public void on(ProduitCreatedEvent event){
        log.info("********************************", event);
        Produit produit = new Produit();
        produit.setId(UUID.randomUUID().toString());
        produit.setName(event.getName());
        produit.setPrice(event.getPrice());
        produit.setQuantite(event.getQuantite());
        produit.setEtat(event.getEtat());
        produit.setCategory(categorieReposetory.findById(event.getId()).get());
        productReposetoies.save(produit);
    }


    @EventHandler
    public void on(CategorieCreatedEvent event){
        log.info("********************************", event);
        Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setName(event.getName());
        category.setDescription(event.getDescription());
        categorieReposetory.save(category);
    }
    @QueryHandler
    public List<Produit> on(GetAllProduit query){
        return productReposetoies.findAll();
    }


}



