package com.fabtec.authentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabtec.authentication.data.vo.AddressVo;
import com.fabtec.authentication.services.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public void create(@RequestBody AddressVo address) {
		addressService.save(address);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update-address")
	public void update(@RequestBody AddressVo addressVo) {
		addressService.update(addressVo);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find")
	public List<AddressVo> findAll() {
		return addressService.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/find/{id}")
	public AddressVo findById(@PathVariable(value = "id") Long id) {
		return addressService.findById(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		addressService.delete(id);
	}
}
