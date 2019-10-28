package com.dev.exceptions;

public class LoginException extends RuntimeException {
  public String getMessage()
	{
		return "Inavalid Username or Password";
	}
}
