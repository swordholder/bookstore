package custom.bookstore;

import custom.bookstore.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validEmail() {
		String validEmail = "joh.doe@mail.com";

		User user = new User();
		user.setEmail(validEmail);
		user.setPassword("123456");
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		Assert.assertTrue(violations.isEmpty());
	}

	@Test
	public void invalidEmailShouldFail() {
		String invalidEmail = "joh.doe@test.com";

		User user = new User();
		user.setEmail(invalidEmail);
		user.setPassword("123456");
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		Assert.assertFalse(violations.isEmpty());
	}

}
