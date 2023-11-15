package com.sorhrani.sorhrani.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorhrani.sorhrani.entities.Categorie;
import com.sorhrani.sorhrani.service.CategorieService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategorieController {

	@Autowired
	private CategorieService service;

	@GetMapping
	public List<Categorie> findAllCategories() {
		return service.findAll();
	}

	@PostMapping
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		categorie.setId(0);
		return service.create(categorie);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategorie(@PathVariable int id, @RequestBody Categorie newcategorie) {
		Categorie oldfCategorie = service.findById(id);
		if (oldfCategorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID" + id + "neexist pas", HttpStatus.BAD_REQUEST);
		} else {
			newcategorie.setId(id);
			return ResponseEntity.ok(service.update(newcategorie));

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFilier(@PathVariable int id) {
		Categorie categorie = service.findById(id);
		if (categorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID" + id + "nexsist pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(categorie);
			return ResponseEntity.ok("Categorie supprimée");
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Categorie categorie = service.findById(id);
		if (categorie == null) {
			return new ResponseEntity<Object>("Categorie avec ID" + id + "nexist pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(categorie);
		}
	}

}
