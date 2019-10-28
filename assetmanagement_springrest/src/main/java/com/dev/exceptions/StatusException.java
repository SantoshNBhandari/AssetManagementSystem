package com.dev.exceptions;

public class StatusException extends RuntimeException {
	public String getMessage()
	{
		return "enter valid allocation id";
	}
}
