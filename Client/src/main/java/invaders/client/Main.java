package invaders.client;

import invaders.client.Communications.Sender;
import invaders.core.Messages.Message;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Message message = new Message();
        message.setOperation(1);
        Sender.sendData(9000, "127.0.0.1", message);
        }
    }

