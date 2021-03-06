package com.harmony.tommy.bval;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.harmony.tommy.bval.Animal;
import com.harmony.tommy.bval.Dog;

public class DogTest {

	private Validator validator;

	@Before
	public void setUp() throws Exception {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void testDog() {
		Dog dog = new Dog();
		Set<ConstraintViolation<Dog>> cvs = validator.validate(dog, Animal.class);
		for(ConstraintViolation<?> cv : cvs){
			System.out.println(cv.getMessage());
		}
		assertEquals("violation size is 3", 3, cvs.size());
	}

	@After
	public void tearDown() throws Exception {
	}

}
