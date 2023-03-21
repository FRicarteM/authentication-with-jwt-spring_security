package com.fabtec.authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.fabtec.authentication.data.vo.AddressVo;
import com.fabtec.authentication.exceptions.BadRequestException;
import com.fabtec.authentication.exceptions.NotFoundException;
import com.fabtec.authentication.mapper.AddressMapper;
import com.fabtec.authentication.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository repository;
	
	//@PreAuthorize("hasAuthority('MANAGER')")
	@PreAuthorize("hasAuthority('COMMON_USER')")
	public AddressVo findById(Long id){
		return AddressMapper.entityToVo(repository.findById(id)
				.orElseThrow(() -> new NotFoundException("The address isn't found")));
				
	}
	
	public List<AddressVo> findAll(){
		List<AddressVo> addresses = new ArrayList<>();
		try {
			addresses = AddressMapper.entityToVoList(repository.findAll());
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		return addresses;
	}
	
	public AddressVo save(AddressVo addressVo) {
		AddressVo address = new AddressVo();
		try {
			address = AddressMapper.entityToVo(
					repository.save(AddressMapper.voToEntity(addressVo)));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
		return address;
	}
	
	
	public void update(AddressVo address) {
		try {
			repository.update(address.getCep(), address.getStreet(), 
					address.getNumber(), address.getCity(), address.getId());
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
	}

	public void delete(Long id) {
		try {
			repository.delete(AddressMapper.voToEntity(findById(id)));
		} catch (BadRequestException bre) {
			bre = new BadRequestException("Something wrong happened with your request");
		}
	}
	
}
