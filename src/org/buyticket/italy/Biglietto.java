package org.buyticket.italy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {

	private static final BigDecimal PRICE_KM = new BigDecimal(0.21);
	
	private static final BigDecimal ELDER_DISCOUNT = new BigDecimal(0.4);
	
	private static final BigDecimal MINOR_DISCOUNT = new BigDecimal(0.2);
	
	private static final int NORMAL_EXP = 30; 
	
	private static final int FLEX_EXP = 90; 
	
	private int kmToRide;
	
	private int age;
	
	LocalDate date = null;
	
	private boolean flexible;
	
	
	public Biglietto(int kmToRide, int age, boolean flexible) throws Exception {
		
		isValidKm(kmToRide);
		isValidAge(age);
		
		date = LocalDate.now();
		setFlexible(flexible);
	}


	public int getKmToRide() {
		return kmToRide;
	}

	private void isValidKm(int kmToRide) throws Exception {
		
		if(kmToRide <= 0) {
			throw new Exception("I km inseriti non sono validi.");
		}
		
		this.kmToRide = kmToRide;
	}

	public int getAge() {
		return age;
	}
	
	private void isValidAge(int age) throws Exception {
		
		if(age <= 0) {
			throw new Exception("L'età non è valida.");
		}
		this.age = age;
	}
	
	private BigDecimal checkDiscount(BigDecimal price) {
		
		BigDecimal discountedPrice = null;
		
		if(age >= 65) {
			discountedPrice = price.multiply(ELDER_DISCOUNT);
		}else if(age < 18) {
			discountedPrice = price.multiply(MINOR_DISCOUNT);
		}else {
			return price;
		}
		
		return price.subtract(discountedPrice);
		
	}

	public float getFinalPrice() {
		
		BigDecimal price = PRICE_KM.multiply(BigDecimal.valueOf(kmToRide));
		
		float finalPrice = checkDiscount(price).floatValue();
		
		if(flexible) {
			return finalPrice + ((finalPrice * 10f) / 100f);
		}else {			
			return checkDiscount(price).floatValue();
		}
	}
	
	public boolean isFlexible() {
		return flexible;
	}

	private void setFlexible(boolean flexible) {
		this.flexible = flexible;
	}
	
	public LocalDate getExpDate() {
		
		if(flexible) {
			return date.plusDays(FLEX_EXP);
		}else {
			return date.plusDays(NORMAL_EXP);
		}
		
	}


	@Override
	public String toString() {
		
		return "Age: " + age 
				+ "\nFinalPrice: " + getFinalPrice() + " $"
				+ "\nTicket exp: " + getExpDate();
	}
	
}
