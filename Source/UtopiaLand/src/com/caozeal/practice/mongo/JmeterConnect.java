package com.caozeal.practice.mongo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.*;
import org.apache.jmeter.protocol.mongodb.mongo.MongoDB;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>创建时间：2018/12/10 13:36
 * <p>com.caozeal.practice.mongo
 * @author caozhiyong
 * @version 1.0
 */
public class JmeterConnect {

    public static void main(String[] args) throws UnknownHostException {
        List<ServerAddress> serverAddresses = new ArrayList<>();
        serverAddresses.add(new ServerAddress("172.16.34.130", 3333));
        MongoDB mongoDB = new MongoDB(serverAddresses, MongoClientOptions.builder().build());
//        DB db = MongoDBHolder.getDBFromSource("tpl", "tpl", "tpl", "tpl_pwd");
        DB db = mongoDB.getDB("tpl", "tpl", "tpl_pwd");
//        BasicDBList values = new BasicDBList();
//        values.add("1c2e8c2bcd38ef2996260669eac20916");
//        values.add("ffc1047da10c236f062503b96ce8d61e");
//        BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$in", values));
//        BasicDBObject query = new BasicDBObject("tplList.name", "测试1");
//        JSONObject json = new JSONObject();
//        json.put("tplList._id", "4a25cf65cdb40def071b1bf4e7174edf");
//        BasicDBObject keys = new BasicDBObject("$set", new BasicDBObject("tplList.$.name", "更新测试2"));
//        keys.put("_id", 0);
//        BasicDBObject ref = new BasicDBObject();
//        ref.put("name", "测试1");
//        ref.put("wslx", "裁定书");
//        BasicDBList tplList = (BasicDBList)(db.getCollection("paragraph_template").findOne( new BasicDBObject("_id","5fced5174d70f0d97d3e3a23ee331343" )).get("tplList"));
//        String dbSize=tplList.size() + "";
//        System.out.println(dbSize);

//        List<String> templatePaths = new ArrayList<>();
//        for(DBObject template : templates){
//            templatePaths.add(template.get("templatePath").toString());
//        }
//        DBObject a = db.getCollection("fy_blank_template").findOne("${tplId}");
//         String b = a.get("_id").toString() + a.get("name") + a.get("templatePath");
//        db.getCollection("custom_template").find(ref).toArray();
        BasicDBObject key=new BasicDBObject();
        key.put("_id", 0);
        key.put("tplId", 1);

        BasicDBObject tj=new BasicDBObject();
        tj.put("userId", "157286789");
        tj.put("fydm", "2400");

        DBCollection dbCollection = db.getCollection("user_collection_template");

            List<DBObject> list = dbCollection.find(tj, key).toArray();
        System.out.println(list);
    }

}
