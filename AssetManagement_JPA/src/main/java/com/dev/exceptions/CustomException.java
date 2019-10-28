package com.dev.exceptions;

public class CustomException extends RuntimeException{

	public CustomException(String string)
	{
		System.err.println(string);
	}
}
