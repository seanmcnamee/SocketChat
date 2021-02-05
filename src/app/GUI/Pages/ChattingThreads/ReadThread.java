package app.GUI.Pages.ChattingThreads;

import java.io.*;
import java.net.*;

import app.GUI.Pages.ChatPage;
 
/**
 * This thread is responsible for reading server's input and writing it to the local user
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private ChatPage chatPage;
 
    public ReadThread(Socket socket, ChatPage chatPage) {
        this.chatPage = chatPage;
        
        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public void run() {
        while (true) {
            try {
                String response = reader.readLine();
                chatPage.addMessage(response, false);
                
                
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}