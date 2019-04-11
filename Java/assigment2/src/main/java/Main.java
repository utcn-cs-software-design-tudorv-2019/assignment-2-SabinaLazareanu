import java.util.List;

import com.assigment2.database.config.HibernateUtil;
import com.assigment2.model.entities.User;
import com.assigment2.model.repositories.UserRepository;
import com.assigment2.model.services.Service;

public class Main {
	public static void main(String[] args) {
		// For Operations DELETE ALL, UPDATE, DELETE, you incoment lines respectives

		Service<User> clienteService = new Service<User>(User.class, HibernateUtil.getSessionFactory());
		
		//clienteService.deleteAll();

		User cliente = new User();
		cliente.setName("Maria da Silva");
		cliente.setAddress("asdfg");
		cliente.setPNC("DBA");
		cliente.setICN("M");

		// Save
		clienteService.save(cliente);

		// Update
		//cliente.setName("Teste Uptade Maria");
		// clienteService.update(cliente);

		// Delete
		//clienteService.delete(cliente);

		// Show All
		System.err.println("Aici");
		List<User> clienteList = clienteService.getAll();
		if (clienteList != null) {
			for (User c : clienteList) {
				System.out.println("Name: " + c.getName().toString());
				System.out.println("Age: " + c.getAddress().toString());
				System.out.println("Profissão: " + c.getPNC().toString());
				System.out.println("Sex: " + c.getICN().toString());
				System.out.println("----------------------------------");
			}
		}

	}
}