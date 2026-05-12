package com.jeev.exception;

import java.time.LocalDateTime;

public class AppException {
	
	private String exCode;

	private Exception exDesc;
	
	private LocalDateTime exDate;
	
	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public Exception getExDesc() {
		return exDesc;
	}

	public void setExDesc(Exception exMsg) {
		this.exDesc = exMsg;
	}

	public LocalDateTime getExDate() {
		return exDate;
	}

	public void setExDate(LocalDateTime exDate) {
		this.exDate = exDate;
	}
}
