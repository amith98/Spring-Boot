package com.example.trainingevent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = GmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } ) 
@Retention(RetentionPolicy.RUNTIME) 

public @interface GmailOnly {
	public String message() default "You email must contain @gmail.com"; 
    public Class<?>[] groups() default {}; 
    public Class<? extends Payload>[] payload() default {}; 

}
