package com.fabtec.authentication.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;


@Builder
@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -8359642297641665074L;
	@Id
	@SequenceGenerator(name = "address_seq", sequenceName = "address_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	private Long id;
	@Column(nullable = false, length = 9)
	private String cep;
	@Column(nullable = false, length = 150)
	private String street;
	@Column(length = 5)
	private int number;
	@Column(nullable = false, length = 68)
	private String city;

	
	public Address() {}

	public Address(Long id, String cep, String street, int number, String city) {
		this.id = id;
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, id, number, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& number == other.number && Objects.equals(street, other.street);
	}

	

}
