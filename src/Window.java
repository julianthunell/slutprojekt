import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(Panel panel){

        //window egenskaper
        this.setVisible(true);
        this.setTitle("Game Window");
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

    }
}
