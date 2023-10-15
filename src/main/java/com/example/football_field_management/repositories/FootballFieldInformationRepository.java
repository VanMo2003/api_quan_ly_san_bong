package com.example.football_field_management.repositories;

import com.example.football_field_management.model.FootballFieldInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballFieldInformationRepository extends JpaRepository<FootballFieldInformation, String> {
	FootballFieldInformation findByNameFootballField(String nameFootballField);
}

