package app.GUI.Pages;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import app.App;
import app.GUI.GUI;
import app.GUI.GUIPage;
public class ListGroupsPage extends GUIPage {
    private ArrayList<ChatPage> pages = new ArrayList<ChatPage>();

    public ListGroupsPage() {
        super();
        this.panel.setBackground(Color.GRAY);
    }

    @Override
    public VariableComponent[] createComponents() {
        VariableComponent[] components = 
        {
            new VariableComponent(new JLabel("Your Groups:", SwingConstants.CENTER), .5, .1, 1, .2),

            new VariableComponent(new JLabel("GROUP:", SwingConstants.CENTER), .3, .3, .2, .05),
            new VariableComponent(new JTextArea(), .5, .3, .2, .05),
            new VariableComponent(new JButton("Add"), .7, .3, .1, .05),


            new VariableComponent(new JButton(""), .5, .4, 1/3.0, .1),
            new VariableComponent(new JButton(""), .5, .5, 1/3.0, .1),
            new VariableComponent(new JButton(""), .5, .6, 1/3.0, .1),
            new VariableComponent(new JButton(""), .5, .7, 1/3.0, .1),
            new VariableComponent(new JButton(""), .5, .8, 1/3.0, .1),

            new VariableComponent(new JButton("Back"), .1, .95, .2, .1)
        };
        this.setBackgroundAndTextOfComponentsInRange(components, 1, 8, Color.BLUE, Color.WHITE);
        this.setBackgroundAndTextOfComponentsInRange(components, 2, 2, Color.WHITE, Color.BLACK);
        ((JLabel) components[0].component).setFont(new Font("Verdana", Font.PLAIN, 20));
        //((JLabel) components[0]).setVerticalTextPosition(AbstractButton.CENTER);
        //vB.component.setHorizontalTextPosition(AbstractButton.LEADING);
        return components;
    }

    @Override
    public void actionPerformed(Object obj, GUI main) {
        for (int i = 0; i < this.pages.size(); i++) {
            if (obj.equals(this.components[i+4].component)) {
                prepareAndSwitchToPage(this.pages.get(i), main);
            }
        }

        if (obj.equals(this.components[3].component)) {
            String groupName = ((JTextArea) this.components[2].component).getText().toString();
            ((JButton) this.components[this.pages.size()+4].component).setText(groupName);
            addGroup(groupName, main);

            clearAllJTextAreas();
        } else if (obj.equals(this.components[this.components.length-1].component)) {
            System.out.println("Back to menu page");
            prepareAndSwitchToPage(App.MENU, main);
        }
    }

    private void addGroup(String group, GUI main) {
        ChatPage cP = new ChatPage(group);
        cP.setButtonListeners(main);

        this.pages.add(cP);
    }
}