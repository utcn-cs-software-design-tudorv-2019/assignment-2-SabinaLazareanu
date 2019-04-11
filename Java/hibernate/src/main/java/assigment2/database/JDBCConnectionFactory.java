package assigment2.database;

public class JDBCConnectionFactory {
	
	public MongoDbConnectionConfig getMongoConnection(String database) {
		return new MongoDbConnectionConfig(database);
	}

}
