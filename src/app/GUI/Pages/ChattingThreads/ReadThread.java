package app.GUI.Pages.ChattingThreads;

import java.io.*;
import java.net.*;

import app.GUI.Pages.ChatPage;
 
/**
 * This thread is responsible for reading server's input and writing it to the local user
 * It runs in an infinite loop until the client disconnects from the server.
 * This is why it needs to be a Thread.
 *
 * @author www.codejava.net
 * @author Altered by Sean McNamee
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private ChatPage chatPage;
 
    /**
     * Instantiate the reader for communication from the server
     */
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
 
    /**
     * Infinitely wait on input from the server.
     * Note that input from the server becomes output to the user (in form of the GUI)
     * 
     * All information here is due to a 'broadcast' from the server
     * If non-string messages were sent, they would have to be recognized here (picture or other information).
     */
    public void run() {
        while (true) {
            try {
                String message = reader.readLine();
                chatPage.addMessage(message, false); //Sends this message to be added to the GUI
                
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }
}