package app.GUI.Pages.ChattingThreads;

import java.io.*;
import java.net.*;
 
/**
 * This thread is responsible for reading user's input and send it to the server.
 * Each write call is waiting on the program. That's why it does NOT need a Thread.
 *
 * @author www.codejava.net
 * @author Altered by Sean McNamee
 */
public class Writer {
    private PrintWriter writer;
    private Socket socket;
 
    /**
     * Instantiate the writer for communication
     * @param socket
     */
    public Writer(Socket socket) {
        this.socket = socket;
        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Close the socket. Should be called at program termination
     */
    public void done() {
        try {
            socket.close();
        } catch (IOException ex) {
 
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }

    /**
     * Message to be sent through the socket to the server
     * @param message
     */
    public void write(String message) {
        writer.println(message);
    }
 
}