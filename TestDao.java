package com.navneet.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import rx.Observable;


@Component
public class TestDao {

	public Observable<Document> getUsersFromDB()

	{
		List<Document> usersList = new ArrayList<>();
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("helloworld");
		MongoCollection<Document> collection = database.getCollection("helloworld");

		FindIterable<Document> iterable = collection.find();
		MongoCursor<Document> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			
			usersList.add(iterator.next());
		}
		mongoClient.close();
		return Observable.from(usersList);
		
	}
}
