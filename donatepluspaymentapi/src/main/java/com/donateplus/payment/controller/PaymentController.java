package com.donateplus.payment.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.donateplus.payment.controller.form.PaymentForm;

/**
 * Users endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
	
	/**
	 * Responsible to pay donation
	 * 
	 * @param userForm
	 * @param uriBuilder
	 * @return 201 - Created
	 */
	@PostMapping
	public ResponseEntity<Long> create(@RequestBody PaymentForm paymentForm, UriComponentsBuilder uriBuilder) {

		LOG.info("Payment referr donation received for user {}", paymentForm.getIdUser());
		
		System.out.println(paymentForm);

		long ret = 1L;

		URI uri = uriBuilder.path("/payments/").buildAndExpand(ret).toUri();

		return ResponseEntity.created(uri).body(ret);
	}

}
