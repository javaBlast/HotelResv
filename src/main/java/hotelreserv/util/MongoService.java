package hotelreserv.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/**
 * Created by Blast on 07.03.2016.
 */
public class MongoService {
    static MongoClientURI uri = new MongoClientURI("mongodb://sardak:benzocar@ds023078.mlab.com:23078/hotreserv");
    public static MongoClient mongoClient = new MongoClient(uri);
    public static MongoDatabase database = mongoClient.getDatabase("hotreserv");
    public static MongoCollection<Document> collection = database.getCollection("hotels");

    public MongoService() {
    }

    public static void printAllDocumentsFromCollection() {
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().values());
        }

    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
