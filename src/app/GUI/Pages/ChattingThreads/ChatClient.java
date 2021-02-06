package app.GUI.Pages.ChattingThreads;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import app.App;
import app.GUI.Pages.ChatPage;

/**
 * The ChatClient deals with overall communication with the server through the socket.
 * It creates a reader and writer to do so.
 * 
 * Note that this class's functionality is USED by the GUI and Reader when recieving information
 * Note that this class USES the functionality of the GUI and Writer when sending information
 * 
 * @author Sean McNamee
 */
public class ChatClient {
    //To connect to the server
    private String hostname;
    private int port;

    //To identify this client
    private String groupName;

    //To update the GUI and server with messages
    private ChatPage chatPage; //GUI Page
    private Writer toThread; //Sending info to the server
    
 
    public ChatClient(ChatPage chatPage, String groupName) {
        this.hostname = "localhost";
        this.port = 8989;
        this.chatPage = chatPage;
        this.groupName = groupName;
    }
 
    /**
     * Connect to the server (through the socket)
     * And create a reader (and start its thread) and writer.
     * 
     * Note that it immediately sends the username and group of this client.
     */
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Connected to the chat server");
 
            new ReadThread(socket, chatPage).start();
            toThread = new Writer(socket);

            writeToThread(App.name);
            writeToThread(groupName);
            
 
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    /**
     * Use the Writer to communicate through the socket with the server
     */
    public void writeToThread(String message) {
        toThread.write(message);
    }

    /**
     * Close the socket. Should be called at program termination
     */
    public void done() {
        toThread.done();
    }

}
