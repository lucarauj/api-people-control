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
import org.springframework.web.bind.annotation.RestController;

import com.api.people.control.dto.PeopleRegisterData;
import com.api.people.control.models.People;
import com.api.people.control.repositories.PeopleRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoas")
@Validated
public class PeopleController {

	@Autowired
	private PeopleRepository peopleRepository;

	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid PeopleRegisterData data) {
		peopleRepository.save(new People(data));
	}

	@GetMapping
	public List<PeopleRegisterData> listPeople() {
		return peopleRepository.findAll().stream().map(PeopleRegisterData::new).toList();
	}

	@GetMapping("/{id}")
	public PeopleRegisterData listPeopleId(@PathVariable Long id) {
		People people = peopleRepository.findById(id).orElseThrow(RuntimeException::new); 
		return new PeopleRegisterData(people);   	
	}

	@PutMapping("/{id}")
	@Transactional
	public void update(@RequestBody @Valid PeopleRegisterData data, @PathVariable Long id) {
		var people = peopleRepository.getReferenceById(id);
		people.updatePeople(data);
	}
}
