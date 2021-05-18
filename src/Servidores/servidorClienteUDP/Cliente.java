package Servidores.servidorClienteUDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Cliente {

    public static void main(String[] args) {
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];


        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "Hola mundo desde el cliente";

            buffer = mensaje.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);


            System.out.println("envio el datagrama");
            socketUDP.send(pregunta);



            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);


            System.out.println("Recibo petición");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);


        } catch (SocketException e) {
            e.printStackTrace();



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
