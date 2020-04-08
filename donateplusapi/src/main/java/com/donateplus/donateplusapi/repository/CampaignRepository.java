package com.donateplus.donateplusapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donateplus.donateplusapi.model.Campaign;

/**
 * This class responsible to access campaign tables
 * 
 * @author j.a.vasconcelos
 *
 */
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

	/**
	 * List all campaings with username
	 * 
	 * @param username
	 * @return
	 */
	List<Campaign> findByUserUsername(String username);
}
