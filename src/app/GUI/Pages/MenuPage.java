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

public class MenuPage extends GUIPage {

    public MenuPage() {
        super();
        this.panel.setBackground(Color.BLACK);
    }

    @Override
    public VariableComponent[] createComponents() {

        VariableComponent[] components = {
                new VariableComponent(new JLabel("Sign in", SwingConstants.CENTER), .5, .1, 1, .2),
                new VariableComponent(new JTextArea(), .5, .4, 1 / 3.0, 1 / 20.0),
                new VariableComponent(new JButton("Continue"), .5, .6, 1 / 3.0, 1 / 6.0) };
        this.setBackgroundAndTextOfComponentsInRange(components, 0, 2, Color.BLUE, Color.WHITE);
        this.setBackgroundAndTextOfComponentsInRange(components, 1, 1, Color.WHITE, Color.BLACK);
        ((JLabel) components[0].component).setFont(new Font("Verdana", Font.PLAIN, 20));
        // ((JLabel) components[0]).setVerticalTextPosition(AbstractButton.CENTER);
        // vB.component.setHorizontalTextPosition(AbstractButton.LEADING);
        return components;
    }

    @Override
    public void actionPerformed(Object obj, GUI main) {
        if(obj.equals(this.components[2].component)) {
            App.name = ((JTextArea) this.components[1].component).getText().toString();
            prepareAndSwitchToPage(App.LIST_GROUPS, main);
        }
    }

}