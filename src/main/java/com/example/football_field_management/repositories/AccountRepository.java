package com.example.football_field_management.repositories;

import com.example.football_field_management.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
