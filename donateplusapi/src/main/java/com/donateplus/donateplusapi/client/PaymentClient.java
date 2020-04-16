package com.donateplus.donateplusapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.donateplus.donateplusapi.controller.dto.DonationDTO;

/**
 * Interface responsible to connect Payment microservice
 * @author j.a.vasconcelos
 *
 */
@FeignClient("payment")
public interface PaymentClient {

	/**
	 * Responsible to create payment
	 * @param donationDTO
	 * @return
	 */
    @RequestMapping(method = RequestMethod.POST, value = "/payments", consumes = "application/json")
	Long create(@RequestBody DonationDTO donationDTO);
}
