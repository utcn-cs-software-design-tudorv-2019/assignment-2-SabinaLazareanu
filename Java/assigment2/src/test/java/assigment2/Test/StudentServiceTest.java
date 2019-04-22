package assigment2.Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assigment2.model.entities.Student;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.StudentRepository;
import com.assigment2.model.services.StudentService;

public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepo;
	private StudentService studentService;
	private Student student;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		studentService = new StudentService(studentRepo);
		student = new Student();
		student.setId(1l);
//		student.setName("Mock Name");
//		student.setPNC("123654");
//		student.setICN("145");
//		student.setAddress("Mock Address");
//		Mockito.when(studentRepo.getById(1)).thenReturn(student);
	}

	@Test
	public void getByIdTest() throws DatabaseAccesException {
		// assertEquals(student, studentService.getByID(1));
	}

}
