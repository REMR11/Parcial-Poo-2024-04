package com.parcialpoo.ufg.MR100823.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcialpoo.ufg.MR100823.models.Menu;
@Repository

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
