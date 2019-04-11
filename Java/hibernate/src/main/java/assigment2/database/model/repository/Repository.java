package assigment2.database.model.repository;

import javax.persistence.EntityManager;

import assigment2.database.JDBCConnectionFactory;
import assigment2.database.model.entityes.User;

public class Repository {

	private JDBCConnectionFactory connection;
	private EntityManager em;

	public Repository(JDBCConnectionFactory connection) {
		this.connection = connection;
	}

	public User gelAll(String name) {
		return (User) em.createQuery("form User u where u.name=:name").setParameter("name", name);
	}
}
