package com.donateplus.donateplusapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.donateplus.donateplusapi.controller.dto.DonationDTO;

/**
 * This class responsible to provide services about donation
 * @author j.a.vasconcelos
 *
 */
@Service
public class DonateService {

	@Autowired
	private RestTemplate client;

	/**
	 * Responsible to call maicroservice payment
	 * 
	 * @param donationDTO
	 * @return return uuid payment.
	 */
	public Long makeDonation(DonationDTO donationDTO) {

		HttpEntity<DonationDTO> request = new HttpEntity<>(donationDTO);

		ResponseEntity<Long> uuid = client.exchange("http://payment/", HttpMethod.POST, request, Long.class);

		return uuid.getBody();

	}

}
