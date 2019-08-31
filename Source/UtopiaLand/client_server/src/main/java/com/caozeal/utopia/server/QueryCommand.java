package com.caozeal.utopia.server;

import com.alibaba.fastjson.JSON;

/**
 * <p>创建时间：2019/8/6 10:46
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class QueryCommand extends AbstractCommand {


    public QueryCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        MongoDao mongoDao = MongoDao.getInstance();
        if(command.length == 3){
            return JSON.toJSONString(mongoDao.query(command[1], command[2]));
        }else {
            return "ERROR; Bad Command";
        }
    }
}
