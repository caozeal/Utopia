package com.caozeal.utopia.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * <p>创建时间：2019/8/7 14:02
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String host = "172.16.192.86";
        int port = 8080;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String command = "z";
        socket.getOutputStream().write(command.getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        System.out.println("result: " + new String(bytes));
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
