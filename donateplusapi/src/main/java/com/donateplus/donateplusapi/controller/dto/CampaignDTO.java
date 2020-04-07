package com.donateplus.donateplusapi.controller.dto;

import java.time.LocalDateTime;

import com.donateplus.donateplusapi.model.Campaign;

/**
 * This class represents DTO Campaign. Responsible to transfer object
 * @author j.a.vasconcelos
 *
 */
public class CampaignDTO {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime createDate;

	public CampaignDTO(Campaign campaign) {

		this.id = campaign.getId();
		this.title = campaign.getTitle();
		this.message = campaign.getMessage();
		this.createDate = campaign.getCreateDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}
