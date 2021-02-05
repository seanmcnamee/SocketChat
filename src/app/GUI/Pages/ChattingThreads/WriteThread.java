package app.GUI.Pages.ChattingThreads;

import java.io.*;
import java.net.*;
 
/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread {
    private PrintWriter writer;
    private Socket socket;
 
    public WriteThread(Socket socket) {
        this.socket = socket;
 
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void done() {
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }

    public void write(String message) {
        writer.println(message);
    }
 
}