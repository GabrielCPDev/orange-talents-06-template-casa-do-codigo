package br.com.zupacademy.gabriel.casadocodigo.resources.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CategoriaInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaInsert {

	String message() default "Erro de validação";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
