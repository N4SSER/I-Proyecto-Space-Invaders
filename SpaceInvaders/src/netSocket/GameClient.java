package netSocket;

import display.Display;
import java.io.IOException;
import java.net.*;

public class GameClient extends Thread{
    private InetAddress ipAddress;
    private DatagramSocket socket;
    private Display display;
    private boolean isActived = true;



    public GameClient(Display display, String ipAddress)
    {
        this.display = display;
        try{
            this.ipAddress = InetAddress.getByName(ipAddress);
            this.socket = new DatagramSocket();
        }catch (SocketException e){
            e.printStackTrace();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
    public void run(){

        System.out.println("Cliente activado");
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
            System.out.println("Server:"+ message);
        }
    }
    public void SendData(byte[] datos){
        DatagramPacket packet = new DatagramPacket(datos, datos.length, ipAddress, 1331);
        try{
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }




    }





}
