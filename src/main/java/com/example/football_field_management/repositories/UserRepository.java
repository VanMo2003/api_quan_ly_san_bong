package com.example.football_field_management.repositories;

import com.example.football_field_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
