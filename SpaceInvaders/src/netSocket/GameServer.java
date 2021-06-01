package netSocket;

import display.Display;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GameServer extends Thread {


    private DatagramSocket socket;
    private Display display;
    private boolean isActived = true;



    public GameServer(Display display)
    {
        this.display = display;
        try{
            this.socket = new DatagramSocket(1331);
        }catch (SocketException e){
            e.printStackTrace();
        }
    }


    //Function that runs the server

    public void run(){

        System.out.println("El servidor está activado");
        while (isActived){
            byte[] datos = new byte[1024];
            DatagramPacket packet = new DatagramPacket(datos, datos.length);

            try{
                socket.receive(packet);
            }catch (IOException e){
                e.printStackTrace();
            }
            //Va cargar una lista de datos que están pasando con un getData

            String message = new String(packet.getData());
            System.out.println("Client["+packet.getAddress().getHostAddress()+":"+packet.getPort()+"]: "+ message);


            if (message.trim().equalsIgnoreCase("ping")){

                SendData("Pong".getBytes(),packet.getAddress(),packet.getPort());
                System.out.println("Returning pong");
            }

        }
    }
    public void SendData(byte[] datos, InetAddress ipAddress, int port){
        DatagramPacket packet = new DatagramPacket(datos, datos.length, ipAddress,port);

        try{
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }




    }

}


