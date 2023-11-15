package com.sorhrani.sorhrani.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sorhrani.sorhrani.entities.Article;

import com.sorhrani.sorhrani.service.ArticleService;





@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@GetMapping
	public List<Article> findAllArticles() {
		return service.findAll();
	}

	@PostMapping
	public Article createArticle(@RequestBody Article article) {
		article.setId(0);
		return service.create(article);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateArticle(@PathVariable int id, @RequestBody Article newarticle) {
		Article oldfArticle = service.findById(id);
		if (oldfArticle == null) {
			return new ResponseEntity<Object>("Article avec ID" + id + "neexist pas", HttpStatus.BAD_REQUEST);
		} else {
			newarticle.setId(id);
			return ResponseEntity.ok(service.update(newarticle));

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteFilier(@PathVariable int id) {
		Article article = service.findById(id);
		if (article == null) {
			return new ResponseEntity<Object>("Article avec ID" + id + "nexsist pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(article);
			return ResponseEntity.ok("Article supprimée");
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Article article = service.findById(id);
		if (article == null) {
			return new ResponseEntity<Object>("Article avec ID" + id + "nexist pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(article);
		}
	}

	@GetMapping("/filterByDate/{id}")
    public List<Article> findByDateBetween(@PathVariable long id,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return service.findByDateBetween(id,dateDebut, dateFin);
    }
}
