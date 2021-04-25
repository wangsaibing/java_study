package com.corejava.mongodb;

import org.bson.Document;
import com.mongodb.MongoClientException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;

import javax.print.Doc;
import javax.xml.crypto.Data;
import java.util.ArrayList;


/**
 * Created by wangsaibing on 2020/10/21.
 */
public class Collection extends Object {

    /**
     * @var collection name
     */
    protected String collectionName;
    /**
     * @var Database
     */
    protected Database database;

    protected MongoCollection mongoCollection;

    public Collection() {

    }

    public Collection(Database database, String collectionName) {
        this.database = database;
        this.collectionName = collectionName;
        this.mongoCollection = this.createMongoCollection(this.collectionName);
    }

    /**
     * 创建 MongoCollection
     * @param collectionName
     * @return
     * @throws MongoClientException
     */
    public MongoCollection createMongoCollection(String collectionName) {
        return this.database.getMongoDatabase().getCollection(collectionName);
    }

    public ArrayList<Document> findAll(int start, int limit) {
        ArrayList<Document> records = new ArrayList<>();

        MongoCursor<Document> cursor = this.mongoCollection.find().skip(start).limit(limit).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String docJson = document.toJson();
                records.add(document);
                //System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return records;
    }

    public MongoCollection getMongoCollection() {
        return this.mongoCollection;
    }

    public String getCollecionName() {
        return this.collectionName;
    }
}