/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import constants.ServerConstants;
import domain.Administrator;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ServerThread extends Thread {

    private ServerSocket ss;
    private static List<ClientHandler> clients;

    public ServerThread() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(ServerConstants.SERVER_CONFIG_FILE_PATH));
        String port = p.getProperty(ServerConstants.SERVER_CONFIG_PORT);
        ss = new ServerSocket(Integer.parseInt(port));
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            System.out.println("Server is running");
            while (!ss.isClosed()) {
                Socket socket = ss.accept();
                System.out.println("New client is here!");
                handleClientRequests(socket);
            }
        } catch (IOException ex) {

        }
        stopAllClients();
    }

    private void handleClientRequests(Socket socket) {
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.start();
        clients.add(clientHandler);
    }

    private void stopAllClients() {
        for (ClientHandler client : clients) {
            try {
                client.getSocket().close();
                clients.remove(client);
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ServerSocket getServerSocket() {
        return ss;
    }

    public void closeServer() {
        try {
            clients.clear();
            ss.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isAdminLoggedIn(Administrator admin) {
        for (ClientHandler client : clients) {
            if (client.getCurrentAdmin() != null && admin.getUsername().equals(client.getCurrentAdmin().getUsername()) && admin.getPassword().equals(client.getCurrentAdmin().getPassword())) {
                return true;
            }
        }
        
        return false;
    }
    
    
    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static List<ClientHandler> getClients() {
        return clients;
    }
    
    
}
