package com.example.football_field_management.controller;


import com.example.football_field_management.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;

@RestController
public class RevenueController {

	@Autowired
	UserDataRepository userDataRepository;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	LocalDateTime now = LocalDateTime.now();

	Calendar calendar = Calendar.getInstance();

	@GetMapping("/revenue/{nameFootballField}")
	ResponseEntity<Object> getAllRevenue(@PathVariable String nameFootballField){

		double revenue = userDataRepository.getALlRevenue(nameFootballField);



		return new ResponseEntity<>(revenue, HttpStatus.OK);
	}

	@GetMapping("/revenueToday/{nameFootballField}")
	ResponseEntity<Object> getRevenueByToday(@PathVariable String nameFootballField){
		Optional<Double> revenueDay = userDataRepository.getRevenueByToDay(nameFootballField, dtf.format(now));

		if (revenueDay.isPresent())
			return new ResponseEntity<>(revenueDay, HttpStatus.OK);
		else
			return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/revenueOfWeek/{nameFootballField}")
	ResponseEntity<Object> getRevenueOfWeek(@PathVariable String nameFootballField){

		LocalDateTime firstDayOfWeek = now.minusDays(calendar.get(Calendar.DAY_OF_WEEK) - 2);

		String revenueOfWeek = "";

		for (int i=0;i<=6;i++){
			Optional<Double> sum = userDataRepository.getRevenueByToDay(nameFootballField, dtf.format(firstDayOfWeek));
			if (i==0){
				if (!sum.isPresent()) {
					revenueOfWeek = revenueOfWeek + 0;
				} else {
					revenueOfWeek = revenueOfWeek + sum.get();
				}
			}else {
				if (!sum.isPresent()) {
					revenueOfWeek = revenueOfWeek + "-" + 0;
				} else {
					revenueOfWeek = revenueOfWeek + "-" + sum.get();
				}
			}
			firstDayOfWeek = firstDayOfWeek.plusDays(1);
		}
		if (revenueOfWeek.equals(""))
			return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(revenueOfWeek, HttpStatus.NOT_FOUND);
	}

//	@GetMapping("/revenueOfMonth/{nameFootballField}")
//	ResponseEntity<Object> getRevenueOfMonth(@PathVariable String nameFootballField){
//
//
//		return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
//	}
}
