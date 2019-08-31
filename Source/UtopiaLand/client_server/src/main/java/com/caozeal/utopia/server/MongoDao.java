package com.caozeal.utopia.server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * <p>创建时间：2019/8/5 17:35
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class MongoDao {

    private MongoClient client;

    private MongoDatabase tplDatabase;

    private MongoCollection auditLoggerMongoCollection;

    private static class DaoHanler{

        private static MongoDao mongoDao = new MongoDao();

        static MongoDao getMongoDao(){
            mongoDao.init();
            return mongoDao;
        }
    }

    private void init(){
        client = MongoClients.create("mongodb://tpl:tpl_pwd@172.16.34.130:5555/tpl");
        tplDatabase = client.getDatabase("tpl");
        auditLoggerMongoCollection = tplDatabase.getCollection("audit_logger");
    }

    public static MongoDao getInstance(){
        return DaoHanler.getMongoDao();
    }

    //FIXME
    public Object query(String name, String description){
        return auditLoggerMongoCollection.find().first();
    }

    //FIXME
    public String report(String cod){
        return auditLoggerMongoCollection.find().first().toString();
    }

}
