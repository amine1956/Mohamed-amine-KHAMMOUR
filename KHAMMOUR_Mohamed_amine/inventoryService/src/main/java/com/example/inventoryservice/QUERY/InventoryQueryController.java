package com.example.inventoryservice.QUERY;

import com.example.inventoryservice.QUERY.entitie.Produit;
import com.example.inventoryservice.QUERY.queries.GetAllProduit;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class InventoryQueryController {

    private QueryGateway queryGateway;


    public InventoryQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    @GetMapping("/getAllProduct")
    public void getAllProduct(){
        queryGateway.query(new GetAllProduit(), ResponseTypes.multipleInstancesOf(Produit.class));
    }
}
