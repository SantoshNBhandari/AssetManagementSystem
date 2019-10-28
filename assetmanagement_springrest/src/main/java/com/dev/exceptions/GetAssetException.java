package com.dev.exceptions;

public class GetAssetException extends RuntimeException {
	public String getMessage()
	{
		return "no assets are available";
	}
}
