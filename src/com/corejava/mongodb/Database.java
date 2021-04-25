package com.corejava.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.client.*;
import com.mongodb.MongoClientException;

import javax.xml.crypto.Data;

import com.corejava.mongodb.Collection;


/**
 * Created by wangsaibing on 2020/10/21.
 */
public class Database extends Object {

    protected MongoDatabase mongoDatabase;
    protected String dbName;

    public Database() {

    }

    public Database(String dbName) {
        this.dbName = dbName;
        this.mongoDatabase = this.createMongoDatabase(this.dbName);
    }

    /**
     * 创建 MongoDatabase
     * @param dbName
     * @return
     * @throws MongoClientException
     */
    public MongoDatabase createMongoDatabase(String dbName) throws MongoClientException {
        MongoDatabase mongoDatabase = Connection.getInstance().getMongoClient().getDatabase(dbName);
        return mongoDatabase;
    }

    public ArrayList<String> listCollectionNames() {
        MongoIterable<String> collectionNames = this.getMongoDatabase().listCollectionNames();

        ArrayList<String> names = new ArrayList<String>();
        for (String name: collectionNames) {
            names.add(name);
        }

        return names;
    }

    public Collection getCollection(String collectionName) throws MongoClientException {
        return new Collection(this, collectionName);
        //return this.database.getCollection(collectionName);
    }

    public MongoDatabase getMongoDatabase() {
        return this.mongoDatabase;
    }

    public String getDbName() {
        return this.dbName;
    }
}