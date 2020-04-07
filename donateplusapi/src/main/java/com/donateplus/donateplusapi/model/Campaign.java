package com.donateplus.donateplusapi.model;

import java.time.LocalDateTime;

/**
 * This class represents a campaing in the application
 * 
 * @author j.a.vasconcelos
 *
 */
public class Campaign {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime createDate;
	private User user;
	private StatusCampaign status = StatusCampaign.NOT_STARTED;

	public Campaign() {

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StatusCampaign getStatus() {
		return status;
	}

	public void setStatus(StatusCampaign status) {
		this.status = status;
	}
}
