package com.bookengine.ws;

public class PaymentInfo {

	private String cardType;
	private String cardNumber;
	
	public PaymentInfo()
	{
		
	}
	
	public PaymentInfo(String cardType, String cardNumber){
		this.cardType = cardType;
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	};

}

