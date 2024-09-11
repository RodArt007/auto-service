package com.automobile.service.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobile.service.entity.Automobile;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {
	
	List<Automobile> findByUserId(Long userId);

}
