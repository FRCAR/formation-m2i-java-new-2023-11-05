package com.bigcorp.project.data.repository;

import com.bigcorp.project.data.contract.AddressService;

/**
 * Gère les opérations sur les User
 */
public class AddressServiceImpl implements AddressService  {

	public String getPostCode(String address) {
		return "44500";
	}
	
}
