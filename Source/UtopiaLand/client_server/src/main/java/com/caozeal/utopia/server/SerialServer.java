package com.caozeal.utopia.server;

import com.caozeal.utopia.server.pojo.exception.ServerStopException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>创建时间：2019/8/6 16:45
 * <p>com.thunisoft.caozeal.server
 * @author caozhiyong
 * @version 1.0
 */
public class SerialServer {

    public static void main(String[] args) throws IOException {
        boolean stopServer = false;
        System.out.println("Initialization completed.");

        try(ServerSocket serverSocket = new ServerSocket(8080)){
            do{
                try(Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    String line = in.readLine();
                    AbstractCommand command;

                    String[] commandData = line.split(";");
                    System.out.println("Command: " + commandData[0]);
                    switch (commandData[0]){
                        case "q":
                            command = new QueryCommand(commandData);
                            break;
                        case "r":
                            command = new ReportCommand(commandData);
                            break;
                        case "z":
                            command = new StopCommand(commandData);
                            break;
                            default:
                                command = new ErrorCommand(commandData);
                    }
                    String response = command.execute();
                    System.out.println(response);
                    out.write(response);
                    out.print(response);
                    out.flush();
                } catch (ServerStopException e) {
                    e.printStackTrace();
                    stopServer = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }while (!stopServer);
        }
    }
}
