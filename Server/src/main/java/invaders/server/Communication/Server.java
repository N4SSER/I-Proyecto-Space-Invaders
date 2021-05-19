package invaders.server.Communication;

import com.fasterxml.jackson.databind.ObjectMapper;
import invaders.core.MessageReader;
import invaders.core.Messages.Message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class Server {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final int PORT = 9000;

    private ServerSocket socket;
    private boolean isActive = true;

    public Server() throws IOException {
        this.socket = new ServerSocket(PORT);
    }

    public void run() throws IOException {

        System.out.println("Esperando a los participantes");
        while(this.isActive){
            try (
                    var inboundConnection = this.socket.accept();
                    var reader = new InputStreamReader(inboundConnection.getInputStream());
                    var writer = new OutputStreamWriter(inboundConnection.getOutputStream());
            ) {
                Message message = this.readAndParse(reader);
                if (message.getOperation() == 1) {
                    writer.write("ACK");
                } else {
                    writer.write("NOT ACK");
                }
                writer.flush();
                writer.flush();
            }
        }
    }

    private Message readAndParse(InputStreamReader reader) throws IOException {
        String data = MessageReader.readMessage(reader, 1024);
        return mapper.readValue(data, Message.class);
    }

    public void stop() {
        this.isActive = false;
    }
}