package Servidores.servidorClienteUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {

        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        try {

            System.out.println("Servidor UDP iniciado");

            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            while(true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);

                System.out.println("Recibo información del cliente");

                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "HOla mundo desde el servidor";
                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                System.out.println("Envio información al cliente");
                System.out.println("------------------------------");
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
