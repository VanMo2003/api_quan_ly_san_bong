package com.example.football_field_management.repositories;

import com.example.football_field_management.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    List<UserData> findByNameFootballField(String nameFootballField);
    List<UserData> findByNumberYard(int numberYard);


    //    @Query(value = "SELECT * FROM user_data WHERE ")
//    List<UserData> findByNameFootballFieldAndNumberYard(@Param("nameFootballField") String nameFootballField);

}
