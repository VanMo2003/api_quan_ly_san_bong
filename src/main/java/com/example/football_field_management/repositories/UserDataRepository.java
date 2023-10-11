package com.example.football_field_management.repositories;

import com.example.football_field_management.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    List<UserData> findByNameFootballField(String nameFootballField);
    List<UserData> findByNumberYard(int numberYard);


    @Query(value = "SELECT SUM(user_data.price) FROM user_data " +
            "WHERE name_football_field LIKE :name",
    nativeQuery = true)
    double getALlRevenue(@Param("name") String name);

    @Query(value = "SELECT SUM(user_data.price) FROM user_data " +
            "WHERE name_football_field LIKE :name " +
            "AND selected_day LIKE :time",
            nativeQuery = true)
    Optional<Double> getRevenueByToDay(@Param("name") String name, @Param("time") String time);

    @Query(value = "SELECT SUM(user_data.price) FROM user_data " +
            "WHERE name_football_field LIKE :name " +
            "AND selected_day BETWEEN :firstDay AND :lastDay",
            nativeQuery = true)
    Optional<Double> getRevenueByPeriod(
            @Param("name") String name,
            @Param("firstDay") String firstDay,
            @Param("lastDay") String lastDay);


//    @Query(value = "SELECT * FROM user_data WHERE user_data.name_football_field =" +
//                " name_football_field AND user_data.data_today = day_today", nativeQuery = true)
//    List<UserData> findByNameFootballFieldAndSelectedTime(
//            @Param("name_football_field") String nameFootballField,
//            @Param("day_today") String dayToday);

}
