package Servidores.servidorClienteTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente { //TCP
    public static void main(String[] args) {

        final String HOST = "192.168.0.6";//IPv4 Address
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;


        try {


            Socket sc = new Socket(HOST,PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola Mundo desde el cliente");

            String mensaje = in.readUTF();
            System.out.println(mensaje);

            sc.close();



        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,e);
        }


    }
}
