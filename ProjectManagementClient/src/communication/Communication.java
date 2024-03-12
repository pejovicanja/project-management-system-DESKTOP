/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.net.Socket;


public class Communication {
    private static Communication instance;
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    

    private Communication() {
        try {
            this.socket = new Socket("localhost", 9000);
            this.sender = new Sender(socket);
            this.receiver = new Receiver(socket);
        } catch (IOException ex) {
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Sender getSender() {
        return sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Socket getSocket() {
        return socket;
    }

    
    
    
}
