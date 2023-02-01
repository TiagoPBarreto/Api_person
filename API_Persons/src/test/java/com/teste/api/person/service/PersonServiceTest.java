package com.teste.api.person.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teste.api.person.mock.PersonMock;
import com.teste.api.person.model.PersonEntity;
import com.teste.api.person.repository.PersonRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	PersonMock input;
	
	@InjectMocks
	private PersonService service;
	
	@Mock
	PersonRepository repository;

	@BeforeEach
	public void setUp() throws Exception {
		input = new PersonMock();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void findById() {
		PersonEntity entity = input.personMock(1);
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		var result = service.findById(1L);
		assertEquals("Some nome1", result.getNome());
		assertNotNull(result.getDatadeNascimento());
		assertEquals("Some Endereço1",result.getEnderecoPrincipal());
		assertEquals(87035510, result.getCep());
		assertEquals(345, result.getNumero());
		assertEquals("Some Cidade1", result.getCidade());
		assertEquals("Some endereço substituto1", result.getEnderecoSubstituto());
		assertEquals(87140000, result.getCepAux());
		assertEquals(534, result.getNumeroAux());
		assertEquals("some Cidade1", result.getCidadeAux());
	
		
	}
	
	@Test
	public void testCreate() {
		PersonEntity entity = input.personMock(1);
		entity.setId(1L);
		
		PersonEntity persisted = entity;
		persisted.setId(1L);
		
		
		when(repository.save(entity)).thenReturn(persisted);
		var result = service.create(persisted);
		
		
		assertEquals("Some nome1", result.getNome());
		assertNotNull(result.getDatadeNascimento());
		assertEquals("Some Endereço1",result.getEnderecoPrincipal());
		assertEquals(87035510, result.getCep());
		assertEquals(345, result.getNumero());
		assertEquals("Some Cidade1", result.getCidade());
		assertEquals("Some endereço substituto1", result.getEnderecoSubstituto());
		assertEquals(87140000, result.getCepAux());
		assertEquals(534, result.getNumeroAux());
		assertEquals("some Cidade1", result.getCidadeAux());
		
		
	}
	
	@Test
	public void testUpdate() {
		PersonEntity entity = input.personMock(1);
		entity.setId(1L);
		
		PersonEntity persisted = entity;
		persisted.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		var result = service.update(persisted);
		
		
		assertEquals("Some nome1", result.getNome());
		assertNotNull(result.getDatadeNascimento());
		assertEquals("Some Endereço1",result.getEnderecoPrincipal());
		assertEquals(87035510, result.getCep());
		assertEquals(345, result.getNumero());
		assertEquals("Some Cidade1", result.getCidade());
		assertEquals("Some endereço substituto1", result.getEnderecoSubstituto());
		assertEquals(87140000, result.getCepAux());
		assertEquals(534, result.getNumeroAux());
		assertEquals("some Cidade1", result.getCidadeAux());
		
		
	}
	
	@Test
	public void testDelete() {
		PersonEntity entity = input.personMock(1); 
		entity.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		
		service.delete(1L);
	}

}
