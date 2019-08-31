package com.caozeal.utopia.server;

/**
 * <p>创建时间：2019/8/6 11:20
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class ReportCommand extends AbstractCommand{

    public ReportCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        MongoDao mongoDao = MongoDao.getInstance();
        return mongoDao.report(command[1]);
    }
}
