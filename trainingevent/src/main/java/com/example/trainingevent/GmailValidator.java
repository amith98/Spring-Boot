package com.example.trainingevent;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GmailValidator implements ConstraintValidator<GmailOnly,String> {
	@Override
	public boolean isValid(String s, ConstraintValidatorContext cvc) {
		s = s.toLowerCase();
		boolean result = s.contains("@gmail.com");
		return result;
	}

}
