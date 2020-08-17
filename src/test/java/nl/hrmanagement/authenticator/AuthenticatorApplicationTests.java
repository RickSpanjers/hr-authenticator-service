package nl.hrmanagement.authenticator;

import nl.hrmanagement.authenticator.dto.*;
import nl.hrmanagement.authenticator.service.impl.AuthenticatorServiceProvider;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author Rick Spanjers
 * @since 21/10/2019
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthenticatorApplicationTests {

	@InjectMocks
	private AuthenticatorServiceProvider userManagementServiceProvider;

	@Before
	public void setUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		MockitoAnnotations.initMocks(this);
	}

	public AuthenticatorApplicationTests() throws ServiceException {

	}

	@Test
	public void setupContext(){

	}

	private static final Logger logger = LoggerFactory.getLogger(AuthenticatorApplicationTests.class);


	@Test(expected = NullPointerException.class)
	public void testLogin_NoUsername(){
		LoginDTO request = new LoginDTO(null, "test");
		GenericResponseDTO actualResult = userManagementServiceProvider.loginUser(request);
		assertTrue(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testLogin_NoPassword(){
		LoginDTO request = new LoginDTO("rick.spanjers@outlook.com", null);
		GenericResponseDTO actualResult = userManagementServiceProvider.loginUser(request);
		assertTrue(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testLogin(){
		LoginDTO request = new LoginDTO("rick.spanjers@outlook.com", "rick123");
		GenericResponseDTO actualResult = userManagementServiceProvider.loginUser(request);
		assertTrue(actualResult.getSuccess());
	}
}
