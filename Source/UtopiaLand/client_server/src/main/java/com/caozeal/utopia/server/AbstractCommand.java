package com.caozeal.utopia.server;

import com.caozeal.utopia.server.pojo.exception.ServerStopException;

/**
 * <p>创建时间：2019/8/6 10:45
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public abstract class AbstractCommand {

    protected final String[] command;

    public AbstractCommand(String[] command) {
        this.command = command;
    }

    public abstract String execute() throws ServerStopException;
}
