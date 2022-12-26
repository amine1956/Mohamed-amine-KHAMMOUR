package com.example.inventoryservice.QUERY.reposetories;

import com.example.inventoryservice.QUERY.entitie.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieReposetory extends JpaRepository<Category, String> {
}

