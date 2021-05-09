package design.patterns.singleton;

import java.io.IOException;
import java.net.ServerSocket;

public class SingletonServer
{
    private static ServerSocket server = null;

    private SingletonServer(){}

    public static ServerSocket getInstance() throws IOException
    {
        if (server == null) {
            server = new ServerSocket();
        }
        else
            System.out.println("Sorry, server is already online");
        return server;
    }
}
