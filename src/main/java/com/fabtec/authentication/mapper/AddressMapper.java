package com.fabtec.authentication.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fabtec.authentication.data.vo.AddressVo;
import com.fabtec.authentication.model.Address;

public class AddressMapper {

	public static Address voToEntity(AddressVo addressVo) {
		Address address = Address.builder()
    			.id(addressVo.getId())
    			.cep(addressVo.getCep())
        		.street(addressVo.getStreet())
        		.number(addressVo.getNumber())
        		.city(addressVo.getCity())
        		.build();
		return address;
	}
	
	public static List<Address> voToEntityList(List<AddressVo> addresses) {
		List<Address> addressList = addresses.stream()
				.map(AddressMapper::voToEntity)
				.collect(Collectors.toList());	
		return addressList;
	}
	
	public static AddressVo entityToVo(Address address) {
		
		AddressVo addressVo = AddressVo.builder()
    			.id(address.getId())
    			.cep(address.getCep())
        		.street(address.getStreet())
        		.number(address.getNumber())
        		.city(address.getCity())
        		.build();		
		return addressVo;
	}
	
	public static List<AddressVo> entityToVoList(List<Address> address) {
		List<AddressVo> addressVoList = address.stream()
				.map(AddressMapper::entityToVo)
				.collect(Collectors.toList());		
		return addressVoList;
	}
	
}
