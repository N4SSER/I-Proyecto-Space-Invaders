package invaders.client.Communications;

import com.fasterxml.jackson.databind.ObjectMapper;
import invaders.core.Display.Display;
import invaders.core.MessageReader;
import invaders.core.Messages.Message;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

    public class Sender {
        private static ObjectMapper mapper = new ObjectMapper();

        public static void sendData(int port, String host, Message message) throws IOException {
            try (
                    var outgoing = new Socket(host, port);
                    var writer = new OutputStreamWriter(outgoing.getOutputStream());
                    var reader = new InputStreamReader(outgoing.getInputStream())
            ) {
                writer.write(mapper.writeValueAsString(message));
                writer.flush();
                outgoing.shutdownOutput();

                var line = MessageReader.readMessage(reader, 1024);
                if (line.startsWith("ACK")) {
                    abrir();
                } else {
                    System.out.println("Server rejected the request");
                }
            }
        }
        public static void abrir() {
            Display display = new Display();
            JFrame frame = new JFrame();
            frame.add(display);
            frame.pack();

            frame.setTitle("Space Invaders");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);

            display.setFrame(frame);
            display.start();
        }
    }

