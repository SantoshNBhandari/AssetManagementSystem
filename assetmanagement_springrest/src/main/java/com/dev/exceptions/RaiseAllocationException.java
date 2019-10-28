package com.dev.exceptions;

public class RaiseAllocationException extends RuntimeException {
	public String getMessage()
	{
		return "allocationId is already present";
	}
}
