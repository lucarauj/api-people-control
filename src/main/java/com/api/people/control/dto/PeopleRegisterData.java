package com.api.people.control.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.api.people.control.models.Address;
import com.api.people.control.models.People;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeopleRegisterData {
	
	Long id;
	@NotBlank
	String nome; 
	@NotNull
	LocalDate nascimento; 
	@Valid
	Set<AddressRegisterData> enderecos;
	
	public PeopleRegisterData() {}
	
	public PeopleRegisterData(People people) {
		this.id = people.getId();
		this.nome = people.getNome();
		this.nascimento = people.getNascimento();
		this.enderecos = new HashSet<>();
		
		for (Address endereco : people.getEnderecos()) {
			this.enderecos.add(new AddressRegisterData(endereco));
		}
	}
}
