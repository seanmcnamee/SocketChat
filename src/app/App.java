package app;

import app.GUI.GUI;
import app.GUI.Pages.MenuPage;
import app.GUI.Pages.ListGroupsPage;

public class App {
    public static int MENU = 0, LIST_GROUPS = 1;
    public static String name = "";
    public static void main(String[] args) throws Exception {
        GUI g = new GUI(new MenuPage(), new ListGroupsPage());
        g.start();
        System.out.println("Hello Java");
    }
}