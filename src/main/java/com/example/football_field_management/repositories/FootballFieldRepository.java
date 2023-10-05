package com.example.football_field_management.repositories;

import com.example.football_field_management.model.FootballField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballFieldRepository  extends JpaRepository<FootballField, String> {
    FootballField findByUsername(String username);
}
