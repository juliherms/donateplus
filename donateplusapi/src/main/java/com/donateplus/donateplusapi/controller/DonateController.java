package com.donateplus.donateplusapi.controller;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.donateplus.donateplusapi.controller.dto.DonationDTO;
import com.donateplus.donateplusapi.service.DonateService;

/**
 * Donate endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/donates")
public class DonateController {

	@Autowired
	DonateService donateService;

	/**
	 * Responsible to create user in the application
	 * 
	 * @param userForm
	 * @param uriBuilder
	 * @return 201 - Created
	 */
	@PostMapping
	public ResponseEntity<Long> create(UriComponentsBuilder uriBuilder) {

		DonationDTO donationDTO = new DonationDTO();
		donationDTO.setAmount(2);
		donationDTO.setIdProduct(1L);
		donationDTO.setIdUser(1L);
		donationDTO.setTotal(BigDecimal.TEN);

		Long uid = donateService.makeDonation(donationDTO);

		URI uri = uriBuilder.path("/donations/{id}").buildAndExpand(uid).toUri();

		return ResponseEntity.created(uri).body(uid);
	}

}
