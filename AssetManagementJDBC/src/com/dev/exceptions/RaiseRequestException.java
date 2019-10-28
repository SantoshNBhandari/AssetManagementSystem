package com.dev.exceptions;

public class RaiseRequestException extends RuntimeException {
	public String getMessage()
	{
		return "Either the Employee for whom you raise the request is not in the Organisation or Assset you Entered is not in the Organisation";
	}
}