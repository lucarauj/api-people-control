package com.api.people.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.people.control.models.People;

public interface PeopleRepository extends JpaRepository<People, Long>{

}
