package com.jiyoung.stock;

public class StockDto {
	
	private String code;
	private String name;
	private int today_price;
	private int next_price;
	private int accuracy;
	private int max0;
	private int max1;
	private int max2;
	private int max3;
	private int max4;
	private int min0;
	private int min1;
	private int min2;
	private int min3;
	private int min4;
	
	public StockDto() {}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getToday_price() {
		return today_price;
	}
	public void setToday_price(int today_price) {
		this.today_price = today_price;
	}
	public int getNext_price() {
		return next_price;
	}
	public void setNext_price(int next_price) {
		this.next_price = next_price;
	}

	public int getMax0() {
		return max0;
	}

	public void setMax0(int max0) {
		this.max0 = max0;
	}

	public int getMax1() {
		return max1;
	}

	public void setMax1(int max1) {
		this.max1 = max1;
	}

	public int getMax2() {
		return max2;
	}

	public void setMax2(int max2) {
		this.max2 = max2;
	}

	public int getMax3() {
		return max3;
	}

	public void setMax3(int max3) {
		this.max3 = max3;
	}

	public int getMax4() {
		return max4;
	}

	public void setMax4(int max4) {
		this.max4 = max4;
	}

	public int getMin0() {
		return min0;
	}

	public void setMin0(int min0) {
		this.min0 = min0;
	}

	public int getMin1() {
		return min1;
	}

	public void setMin1(int min1) {
		this.min1 = min1;
	}

	public int getMin2() {
		return min2;
	}

	public void setMin2(int min2) {
		this.min2 = min2;
	}

	public int getMin3() {
		return min3;
	}

	public void setMin3(int min3) {
		this.min3 = min3;
	}

	public int getMin4() {
		return min4;
	}

	public void setMin4(int min4) {
		this.min4 = min4;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
}
