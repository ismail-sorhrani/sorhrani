package com.sorhrani.sorhrani.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "categorie")
	List<Article> articles;
	@ManyToOne
	private Categorie categorieParent;

	public Categorie() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Categorie getCategorieParent() {
		return categorieParent;
	}

	public void setCategorieParent(Categorie categorieParent) {
		this.categorieParent = categorieParent;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


}
