package com.sorhrani.sorhrani.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorhrani.sorhrani.dao.IDao;
import com.sorhrani.sorhrani.entities.Article;

import com.sorhrani.sorhrani.repository.ArticleRepository;





@Service
public class ArticleService implements IDao<Article> {
	@Autowired
	private ArticleRepository repository;

	@Override
	public Article create(Article article) {
		return repository.save(article);
	}

	@Override
	public boolean delete(Article article) {
		try {
			repository.delete(article);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Article update(Article article) {
		return repository.save(article);
	}

	@Override
	public Article findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Article> findAll() {
		return repository.findAll();
	}
	public List<Article> findByDateBetween(Long id,Date dateDebut, Date dateFin) {
        return repository.findByDateBetween(id,dateDebut, dateFin);
    }


}