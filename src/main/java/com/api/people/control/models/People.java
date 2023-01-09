package com.api.people.control.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.api.people.control.dto.AddressRegisterData;
import com.api.people.control.dto.PeopleRegisterData;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "PEOPLE")
@Entity(name = "People")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	private LocalDate nascimento;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "people", cascade = CascadeType.ALL)
	private Set<Address> enderecos = new HashSet<>();

	public People(PeopleRegisterData data) {
		this.nome = data.getNome();
		this.nascimento = data.getNascimento();
		if (data.getEnderecos() != null && !data.getEnderecos().isEmpty()) {

			for (AddressRegisterData addressDto : data.getEnderecos()) {

				Address endereco = new Address(addressDto);
				endereco.setPeople(this);
				this.enderecos.add(endereco);
			}
		}
	}

	public void updatePeople(PeopleRegisterData data) {
		this.nome = data.getNome();
		this.nascimento = data.getNascimento();
	}
}
