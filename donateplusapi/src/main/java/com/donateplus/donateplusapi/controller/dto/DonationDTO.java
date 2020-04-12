package com.donateplus.donateplusapi.controller.dto;

import java.math.BigDecimal;

public class DonationDTO {

	private Long idUser;
	private Long idProduct;
	private int amount;
	private BigDecimal toal;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public BigDecimal getToal() {
		return toal;
	}
	public void setToal(BigDecimal toal) {
		this.toal = toal;
	}
}
