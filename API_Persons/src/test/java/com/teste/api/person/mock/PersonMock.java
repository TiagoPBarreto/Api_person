package com.teste.api.person.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.teste.api.person.model.PersonEntity;

public class PersonMock {

	public PersonEntity personMock() {
		return personMock(0);
	}
	
	public List<PersonEntity> personMockList(){
		List<PersonEntity> persons = new ArrayList<PersonEntity>();
		 for (int i = 0; i < 14; i++) {
	            persons.add(personMock(i));
	        }
		 return persons;
	}
	
	public PersonEntity personMock(Integer number){
		PersonEntity person = new PersonEntity();
		person.setId(number.longValue());
		person.setNome("Some nome" + number);
		person.setDatadeNascimento(new Date());
		person.setEnderecoPrincipal("Some Endereço" + number);
		person.setCep(87035510);
		person.setNumero(345);
		person.setCidade("Some Cidade" + number);
		person.setEnderecoSubstituto("Some endereço substituto" + number);
		person.setCepAux(87140000);
		person.setNumeroAux(534);
		person.setCidadeAux("some Cidade" + number);
		
		return person;
	}
	
}
