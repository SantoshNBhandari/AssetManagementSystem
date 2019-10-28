package com.dev.exceptions;

public class StatusExcpetion extends RuntimeException {
	public String getMessage()
	{
		return "Can't Set STatus:Invalid Allocation Id";
	}
}
