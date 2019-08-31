package com.caozeal.utopia.server;

import com.caozeal.utopia.server.pojo.exception.ServerStopException;

/**
 * <p>创建时间：2019/8/6 11:23
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class StopCommand extends AbstractCommand {
    public StopCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() throws ServerStopException {
        throw new ServerStopException();
    }
}
