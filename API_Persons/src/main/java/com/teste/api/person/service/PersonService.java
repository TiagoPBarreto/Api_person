package com.teste.api.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.api.person.exception.ResourceNotFoundException;
import com.teste.api.person.model.PersonEntity;
import com.teste.api.person.repository.PersonRepository;
@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	public Page<PersonEntity>findAll(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public PersonEntity findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Ops! Algo deu errado "));
	}
	
	public PersonEntity update(PersonEntity person) {
		PersonEntity entity = repository.findById(person.getId())
				.orElseThrow(()-> new ResourceNotFoundException("Ops! Algo deu errado ao salvar"));
				
				entity.setNome(person.getNome());
				entity.setDatadeNascimento(person.getDatadeNascimento());
				entity.setEnderecoPrincipal(person.getEnderecoPrincipal());
				entity.setCep(person.getCep());
				entity.setNumero(person.getNumero());
				entity.setCidade(person.getCidade());
				entity.setEnderecoSubstituto(person.getEnderecoSubstituto());
				entity.setCepAux(person.getCepAux());
				entity.setNumeroAux(person.getNumeroAux());
				entity.setCidadeAux(person.getCidadeAux());
				
		return repository.save(person);
	}
	
	public PersonEntity create(PersonEntity person) {
		return repository.save(person);
	}
	
	public void delete(Long id) {
		PersonEntity entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Ops! Algo deu errado ao deletar Pessoa"));
		 repository.delete(entity);
	}
}
