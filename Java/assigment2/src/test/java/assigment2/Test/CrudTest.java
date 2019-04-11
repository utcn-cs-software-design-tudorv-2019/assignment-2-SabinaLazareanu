package assigment2.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import com.assigment2.model.entities.Student;
import com.assigment2.model.entities.User;

public class CrudTest {

	@Test
	public void crud() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		create2(session);
		// read(session);

//        update(session);
//        read(session);
//         
//        delete(session);
//        read(session);

		session.close();
	}

	private void delete(Session session) {
		System.out.println("Deleting mondeo record...");
		User mondeo = (User) session.get(User.class, "Sabina");

		session.beginTransaction();
		session.delete(mondeo);
		session.getTransaction().commit();
	}

	private void update(Session session) {
		System.out.println("Updating mustang price...");
		User mustang = (User) session.get(User.class, "mustang");
		mustang.setName("mustang");
		mustang.setAddress("£35,250.00");

		session.beginTransaction();
		session.saveOrUpdate(mustang);
		session.getTransaction().commit();
	}

	private void create(Session session) {
		System.err.println("Creating car records...");
		User mustang = new User();
		mustang.setName("mustang");
		mustang.setAddress("£35,250.00");

		User mondeo = new User();
		mustang.setName("mustang");
		mustang.setAddress("£35,250.00");

		System.err.println("1");
		session.beginTransaction();
		System.err.println("2");
		session.save(mustang);
		System.err.println("3");
		session.save(mondeo);
		session.getTransaction().commit();
	}

	private void create2(Session session) {
		System.err.println("Creating car records...");
		Student mustang = new Student();
		mustang.setUserName("mustang");
		mustang.setPassword("£35,250.00");

		System.err.println("1");
		session.beginTransaction();
		System.err.println("2");
		session.save(mustang);
		session.getTransaction().commit();
	}

	private void read(Session session) {
		Query q = session.createQuery("select _user from User _user");

		List cars = q.list();
		System.out.println(cars.toString());

		System.out.println("Reading car records...");
		System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
//        for (User c : cars) {
//            System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
//        }
	}
}
