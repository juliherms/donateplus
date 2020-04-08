package com.donateplus.donateplusapi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This class represents a campaing in the application
 * 
 * @author j.a.vasconcelos
 *
 */
@Entity(name = "TB_CAMPAIGN")

public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;
	private LocalDateTime createDate = LocalDateTime.now();
	@ManyToOne
	private User user;
	@Enumerated(EnumType.STRING)
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
