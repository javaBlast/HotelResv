package ch.makery.address.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


/**
 * Created by Blast on 07.03.2016.
 */
public class MongoService {
    public static MongoClient mongoClient = new MongoClient();
    public static MongoDatabase database = mongoClient.getDatabase("reserveserv");
    public static MongoCollection<Document> collection = database.getCollection("hotels");

    public MongoService() {
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


    public static void printAllDocumentsFromCollection() {
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next().values());
        }

    }
}
