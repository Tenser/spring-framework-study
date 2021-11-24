package com.jiyoung.stock;

import java.sql.Timestamp;

public class TimeUpdateDto {
	Timestamp currenttime;
	public TimeUpdateDto() {}
	public Timestamp getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(Timestamp currenttime) {
		this.currenttime = currenttime;
	}
	
}
