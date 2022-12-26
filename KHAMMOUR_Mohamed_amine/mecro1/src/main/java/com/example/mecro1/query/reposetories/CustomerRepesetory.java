package com.example.mecro1.query.reposetories;

import com.example.mecro1.query.entite.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepesetory extends JpaRepository<Customer, String> {
}

