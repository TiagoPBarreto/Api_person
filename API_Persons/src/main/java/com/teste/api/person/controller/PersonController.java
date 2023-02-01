package com.teste.api.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
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

import com.teste.api.person.model.PersonEntity;
import com.teste.api.person.service.PersonService;



@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PersonEntity>>findAll(
			@RequestParam(value = "page",defaultValue = "0")Integer page,
			@RequestParam(value = "limit",defaultValue = "13")Integer limit){
		Pageable pegeable = PageRequest.of(page, limit);
		return ResponseEntity.ok(service.findAll(pegeable));
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity findById(
			@PathVariable(value = "id") Long id)throws Exception {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity create(
			@RequestBody PersonEntity person)throws Exception {
		return service.create(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonEntity update(
			@RequestBody PersonEntity person) throws Exception {
		return service.create(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?>delete(@PathVariable(value = "id")Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
