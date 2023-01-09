package com.api.people.control.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.people.control.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByPeopleId(long peopleId);

}
