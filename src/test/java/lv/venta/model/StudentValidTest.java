package lv.venta.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class StudentValidTest {

	private Validator validator;
	
	@BeforeEach
	public void initialize() {
		ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void validateGoodStudent() {
		Student student = new Student("Karina", "Šķirmante");
		Set<ConstraintViolation<Student>> problems 
			= validator.validate(student);
		
		assertTrue(problems.isEmpty());
		//var arī šādā variantā pārbaudīt, ka nav validaciju pāŗkāpumi
		//assertEquals(0, problems.size());
		
	}
	@Test
	public void validateWrongStudent() {
		Student student = new Student("", "13124124");
		Set<ConstraintViolation<Student>> problem
		= validator.validate(student);
		assertFalse(problem.isEmpty());//noteikti jābūt validacijas pārkāpumiem
		//pārbaudei, kādi validācijas pāŗkāpumi ir
		for(ConstraintViolation<Student> tempS : problem) {
			System.out.println(tempS.getMessage());
		}
		
	}

}
