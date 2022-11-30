import Controller.*;
import View.StatusBar;
import java.awt.BorderLayout;
import javax.swing.*;

public class Main extends JFrame{

    static StatusBar status = StatusBar.getStatus();


    public Main(){
        MainController mainController = MainController.getInstance();
        setLayout(new BorderLayout(3, 2));
        getContentPane().add(mainController.getAppPanelController().getAppPanel());
        getContentPane().add(status, java.awt.BorderLayout.SOUTH);

        setSize(1000, 1000);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame main = new Main();
    }

}
