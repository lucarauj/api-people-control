package com.api.people.control.dto;

import com.api.people.control.models.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRegisterData(
		
		Long id,
		Integer principal,		
		@NotBlank
		String logradouro,
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep,
		@NotBlank
		String numero,
		@NotBlank
		String cidade) {
	
	public AddressRegisterData(Address address) {
		this(address.getId(), address.getPrincipal(), address.getLogradouro(), address.getCep(), address.getNumero(), address.getCidade());
	}
}