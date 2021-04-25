package com.corejava.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;


/**
 * Created by wangsaibing on 2020/10/21.
 */
public class Connection {

    protected static Connection instance;

    protected MongoClient mongoClient;
    //protected String uri = "mongodb://127.0.0.1:27017,localhost:27017";
    protected String uri = "mongodb://127.0.0.1:27017";

    protected Connection() {
        this.mongoClient = MongoClients.create(this.uri);
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public MongoClient getMongoClient() {
        return this.mongoClient;
    }

//    public MongoDatabase getMongoDatabase(String dbName) {
//        return Connection.getInstance().getMongoClient().getDatabase(dbName);
//    }
}