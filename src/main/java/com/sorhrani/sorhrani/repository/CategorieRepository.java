package com.sorhrani.sorhrani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorhrani.sorhrani.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
