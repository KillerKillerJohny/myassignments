package com.productApi.productApiAssignment.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {
	private String message;
	public ResourceNotFoundException(String msg) {
		this.message=msg;
	}
}
