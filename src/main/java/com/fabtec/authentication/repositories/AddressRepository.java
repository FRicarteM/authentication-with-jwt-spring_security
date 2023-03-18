package com.fabtec.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabtec.authentication.model.Address;

import jakarta.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Address a SET a.cep = :cep, a.street = :street, "
			+ "a.number = :number, a.city = :city WHERE a.id = :id")
	void update(@Param("cep") String cep, @Param("street") String street,
			@Param("number") int number, @Param("city") String city, @Param("id") Long id);
}
