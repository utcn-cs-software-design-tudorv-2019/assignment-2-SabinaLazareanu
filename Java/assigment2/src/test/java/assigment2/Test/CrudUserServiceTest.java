package assigment2.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.assigment2.model.entities.User;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.UserRepository;
import com.assigment2.model.services.UserService;

public class CrudUserServiceTest {

	@Mock
	private UserRepository userRepo;
	private UserService userService;
	private User user;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		userService = new UserService(userRepo);
		user = new User();
		user.setId(1l);
		user.setName("Mock Name");
		user.setPNC("123654");
		user.setICN("145");
		user.setAddress("Mock Address");
		Mockito.when(userRepo.getById(1)).thenReturn(user);
	}

	@Test
	public void getByIdTest() throws DatabaseAccesException {
		assertEquals(user, userService.getByID(1));
	}

}
