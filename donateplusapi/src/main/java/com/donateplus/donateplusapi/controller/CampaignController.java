package com.donateplus.donateplusapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donateplus.donateplusapi.model.Campaign;

/**
 * Campaigns endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
public class CampaignController {

	/**
	 * List all campaings
	 * 
	 * @return
	 */
	@RequestMapping("/campaigns")
	public List<Campaign> list() {
		return null;
	}
}
