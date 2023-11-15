package com.sorhrani.sorhrani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorhrani.sorhrani.dao.IDao;
import com.sorhrani.sorhrani.entities.Categorie;
import com.sorhrani.sorhrani.repository.CategorieRepository;
@Service
public class CategorieService  implements IDao<Categorie> {
	@Autowired
	private CategorieRepository repository;

	@Override
	public Categorie create(Categorie categorie) {
		return repository.save(categorie);
	}

	@Override
	public boolean delete(Categorie categorie) {
		try {
			repository.delete(categorie);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Categorie update(Categorie categorie) {
		return repository.save(categorie);
	}

	@Override
	public Categorie findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Categorie> findAll() {
		return repository.findAll();
	}
	

}