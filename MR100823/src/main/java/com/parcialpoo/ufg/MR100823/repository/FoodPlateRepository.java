package com.parcialpoo.ufg.MR100823.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;

@Repository
public interface FoodPlateRepository extends JpaRepository<FoodPlate, Integer> {

}
