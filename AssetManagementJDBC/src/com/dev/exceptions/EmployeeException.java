package com.dev.exceptions;

public class EmployeeException extends RuntimeException {

	public String getMessage()
	{
		return "Employee Not Added";
	}
}