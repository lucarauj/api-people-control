package com.api.people.control.models;

import com.api.people.control.dto.AddressRegisterData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ADDRESS")
@Entity(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer principal = 1;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	
	@ManyToOne
    @JoinColumn(name="people_id", nullable=false)
    private People people;
	
	public Address(AddressRegisterData data) {
		this.logradouro = data.logradouro();
		this.cep = data.cep();
		this.numero = data.numero();
		this.cidade = data.cidade();
	}
	
	public void updateAddress(AddressRegisterData data) {		
		this.logradouro = data.logradouro();
		this.cep = data.cep();
		this.numero = data.numero();
		this.cidade = data.cidade();
	}
}
