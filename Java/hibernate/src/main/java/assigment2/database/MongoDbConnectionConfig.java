package assigment2.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDbConnectionConfig {

	private static MongoClient mongoClient;
	private static DB db;

	public MongoDbConnectionConfig(String database) {
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDB(database);
	}

	public DBCollection getCollection(String collection) {
		return db.getCollection(collection);
	}

}
