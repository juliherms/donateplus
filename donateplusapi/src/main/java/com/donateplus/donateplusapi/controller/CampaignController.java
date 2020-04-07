package com.donateplus.donateplusapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.donateplus.donateplusapi.model.Campaign;

/**
 * Campaigns endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@Controller
public class CampaignController {

	/**
	 * List all campaings
	 * 
	 * @return
	 */
	@RequestMapping("/campaigns")
	@ResponseBody
	public List<Campaign> list() {
		return null;
	}
}
