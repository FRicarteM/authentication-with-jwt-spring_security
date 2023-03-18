package com.fabtec.authentication.data.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Builder;

@Builder
public class AddressVo implements Serializable{

	private static final long serialVersionUID = 8737505479250339673L;

	private Long id;
	private String cep;
	private String street;
	private int number;
	private String city;

		
	public AddressVo() {}

	public AddressVo(Long id, String cep, String street, int number, String city) {
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
		if(!(obj instanceof AddressVo))
			return false;
		AddressVo other = (AddressVo) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& number == other.number && Objects.equals(street, other.street);
	}
	
	
}
