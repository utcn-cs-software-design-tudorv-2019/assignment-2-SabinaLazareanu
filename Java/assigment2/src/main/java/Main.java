import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.repositories.CourseRepository;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.EnrollementRepository;
import com.assigment2.model.repositories.StudentRepository;
import com.assigment2.model.repositories.TeacherRepository;
import com.assigment2.model.services.CourseService;
import com.assigment2.model.services.EnrollementService;
import com.assigment2.model.services.StudentService;
import com.assigment2.model.services.TeacherService;

public class Main {
	public static void main(String[] args) {
		// For Operations DELETE ALL, UPDATE, DELETE, you incoment lines respectives

		// Service<User> clienteService = new Service<User>(User.class,
		// HibernateUtil.getSessionFactory());

		// clienteService.deleteAll();

//		User cliente = new User();
//		cliente.setName("Sabina");
//		cliente.setAddress("asdfg");
//		cliente.setPNC("DBA");
//		cliente.setICN("M");
//
//		// Save
//		try {
//			userService.save(cliente);
//		} catch (DatabaseAccesException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// Update
//		cliente.setName("Teste Uptade Maria");
//		try {
//			userService.update(cliente);
//		} catch (DatabaseAccesException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		// Delete
//		try {
//			userService.delete(cliente);
//		} catch (DatabaseAccesException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// Show All
//		System.err.println("Aici");
//		List<User> clienteList;
//		try {
//			clienteList = userService.getAll();
//			if (clienteList != null) {
//				for (User c : clienteList) {
//					System.out.println(c.toString());
//				}
//			}
//		} catch (DatabaseAccesException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			StudentService studentService = new StudentService(HibernateUtil.getSessionFactory());
//			UserService userService = new UserService(HibernateUtil.getSessionFactory());
//			User user = new User();
//			user.setName("Sabina");
//			user.setAddress("Obs");
//			user.setPNC("123654");
//			user.setICN("456321");
//
//			userService.save(user);
//
//			System.err.println(user.getId());
//			Student student = new Student();
//			student.setUserName("sabina");
//			student.setPassword("123");
//			student.setGroup("30233");
//			student.setUser(user);
//			student = studentService.save(student);
//			
//		} catch (DatabaseAccesException e) {
//
//		}
		StudentRepository studentRepo = new StudentRepository(HibernateUtil.getSessionFactory());
		StudentService student = new StudentService(studentRepo);

		try {
			System.err.println(student.getAll());
			System.err.println(student.getByID(1l).getEnrollement());
		} catch (DatabaseAccesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TeacherRepository teachertRepository = new TeacherRepository(HibernateUtil.getSessionFactory());
		TeacherService teacher = new TeacherService(teachertRepository);

		try {
			System.err.println(teacher.getAll());
		} catch (DatabaseAccesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CourseRepository courseRepository = new CourseRepository(HibernateUtil.getSessionFactory());
		CourseService course = new CourseService(courseRepository);

		try {
			System.err.println(course.getAll());
		} catch (DatabaseAccesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EnrollementRepository enrollementRepository = new EnrollementRepository(HibernateUtil.getSessionFactory());
		EnrollementService enrollment = new EnrollementService(enrollementRepository);

		try {
			System.err.println(enrollment.getAll());
		} catch (DatabaseAccesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}