package app.GUI.Pages.ChattingThreads;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import app.App;
import app.GUI.Pages.ChatPage;

public class ChatClient {
    private String hostname;
    private int port;
    private ChatPage chatPage;
    private WriteThread toThread;
    private String groupName;
 
    public ChatClient(ChatPage chatPage, String groupName) {
        this.hostname = "localhost";
        this.port = 8989;
        this.chatPage = chatPage;
        this.groupName = groupName;
    }
 
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
 
            System.out.println("Connected to the chat server");
 
            new ReadThread(socket, chatPage).start();
            toThread = new WriteThread(socket);

            writeToThread(App.name);
            writeToThread(groupName);
            
 
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public void writeToThread(String message) {
        toThread.write(message);
    }

    public void done() {
        toThread.done();
    }

}
