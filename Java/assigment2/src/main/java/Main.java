import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.repositories.DatabaseAccesException;
import com.assigment2.model.repositories.StudentRepository;
import com.assigment2.model.services.StudentService;

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
		} catch (DatabaseAccesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Service<Student> service = new Service(Student.class, HibernateUtil.getSessionFactory());
//		System.err.println(service.getAll());
	}
}