package com.sorhrani.sorhrani.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sorhrani.sorhrani.entities.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	@Query("SELECT a FROM Article a WHERE categorie.id=:categorieId AND dateProduction BETWEEN :date1 AND :date2")
	List<Article> findByDateBetween(Date dateDebut, Date dateFin);

}
