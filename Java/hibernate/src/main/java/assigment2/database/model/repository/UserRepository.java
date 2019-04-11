package assigment2.database.model.repository;

import assigment2.database.JDBCConnectionFactory;

public class UserRepository extends Repository {

	public UserRepository(JDBCConnectionFactory connection) {
		super(connection);
	}

}
