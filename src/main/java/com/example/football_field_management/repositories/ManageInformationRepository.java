package com.example.football_field_management.repositories;

import com.example.football_field_management.model.ManageInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManageInformationRepository extends JpaRepository<ManageInformation, String> {
	ManageInformation findByNameFootballField(String nameFootballField);
}

