package app.GUI.Pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.App;
import app.GUI.GUI;
import app.GUI.GUIPage;

public class ChatPage extends GUIPage {
    private String chatArea = "";

    public ChatPage(int port) {
        super();
        this.panel.setBackground(Color.GRAY);
    }

    @Override
    public VariableComponent[] createComponents() {
        VariableComponent[] components = 
        {
            new VariableComponent(new JLabel("GroupName", SwingConstants.CENTER), .5, .1, 1, .2),

            new VariableComponent(new JLabel(chatArea), .5, .4, 1/3.0, 1/4.0),

            new VariableComponent(new JTextArea(), .4, .8, .25, .05),
            new VariableComponent(new JButton("Send"), .6, .8, .1, .05),

            new VariableComponent(new JButton("Back"), .1, .95, .2, .1)
        };
        this.setBackgroundAndTextOfComponentsInRange(components, 1, 3, Color.BLUE, Color.WHITE);
        this.setBackgroundAndTextOfComponentsInRange(components, 2, 2, Color.WHITE, Color.BLACK);
        ((JLabel) components[0].component).setFont(new Font("Verdana", Font.PLAIN, 20));
        //((JLabel) components[0]).setVerticalTextPosition(AbstractButton.CENTER);
        //vB.component.setHorizontalTextPosition(AbstractButton.LEADING);
        return components;
    }

    @Override
    public void actionPerformed(Object obj, GUI main) {
        if (obj.equals(this.components[3].component)) {
            String message = ((JTextArea) this.components[2].component).getText().toString();
            addMessage("[" + App.name + "] " + message);
        } else if (obj.equals(this.components[this.components.length-1].component)) {
            System.out.println("Back to menu page");
            prepareAndSwitchToPage(App.LIST_GROUPS, main);
        }
    }

    public void addMessage(String message) {
        this.chatArea += "<br>" + message;
        ((JLabel) this.components[1].component).setText("<HTML>" + this.chatArea + "</HTML>");
        clearAllJTextAreas();
    }
}