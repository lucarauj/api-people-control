package com.api.people.control.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.people.control.dto.AddressRegisterData;
import com.api.people.control.models.Address;
import com.api.people.control.models.People;
import com.api.people.control.repositories.AddressRepository;
import com.api.people.control.repositories.PeopleRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoas")
@Validated
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PeopleRepository peopleRepository;

	@PostMapping("{id}/enderecos")
	@ResponseBody
	@Transactional
	public AddressRegisterData register(@RequestBody @Valid AddressRegisterData data, @PathVariable Long id) {
		People people = peopleRepository.findById(id).orElseThrow(RuntimeException::new);

		for (Address endereco : people.getEnderecos()) {
			if (endereco.getPrincipal() == 1) {
				endereco.setPrincipal(0);
			}
		}

		Address address = new Address(data);
		address.setPeople(people);
		return new AddressRegisterData(addressRepository.save(address));
	}

	@GetMapping("{peopleId}/enderecos")
	public List<AddressRegisterData> listAddressId(@PathVariable Long peopleId) {
		return addressRepository.findByPeopleId(peopleId).stream().map(AddressRegisterData::new).toList();
	}

	@GetMapping("{peopleId}/enderecos/principal")
	public AddressRegisterData listAddressMain(@PathVariable Long peopleId) {
		var enderecos = addressRepository.findByPeopleId(peopleId);
		Address enderecoPrincipal = new Address();
		for (Address endereco : enderecos) {
			if (endereco.getPrincipal() == 1) {
				enderecoPrincipal = endereco;
			}
		}
		return new AddressRegisterData(enderecoPrincipal);
	}

	@PutMapping("enderecos/{id}")
	@Transactional
	public void updateAddress(@RequestBody @Valid AddressRegisterData data, @PathVariable Long id) {
		var address = addressRepository.getReferenceById(id);
		address.updateAddress(data);
	}

	@PutMapping("{peopleId}/enderecos/principal/{enderecoId}")
	@Transactional
	public void updateAddressMain(@PathVariable Long peopleId, @PathVariable Long enderecoId) {

		var enderecos = addressRepository.findByPeopleId(peopleId);

		for (Address endereco : enderecos) {
			if (endereco.getId() == enderecoId) {
				endereco.setPrincipal(1);
			} else {
				endereco.setPrincipal(0);
			}
		}

		addressRepository.saveAll(enderecos);
	}
}
