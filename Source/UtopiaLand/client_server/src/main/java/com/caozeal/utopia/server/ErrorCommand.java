package com.caozeal.utopia.server;

/**
 * <p>创建时间：2019/8/6 16:19
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class ErrorCommand extends AbstractCommand {


    public ErrorCommand(String[] command) {
        super(command);
    }

    @Override
    public String execute() {
        return "Unknow command: " + command[0];
    }
}
