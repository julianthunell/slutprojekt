import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {
    static int windowWidth = 800;
    private long lastCheck = 0;
    private int frames = 0;
    static int windowHeight = (windowWidth/16) * 9;
    public Panel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.addKeyListener(this);

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("Fps: "+frames);
            frames = 0;
        }
    }
    public void updateGame (){
    }
    static boolean playerDown, playerUp, playerRight, playerLeft;


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int input = (e.getKeyCode());
        System.out.println(e.getKeyCode());

        //startar movement när knapp trycks
        switch (input){
            case 87:
                playerUp =true;
                System.out.println("test");
                break;
            case 83:
                playerDown=true;
                break;
            case 65:
                playerLeft =true;
                break;
            case 68:
                playerRight =true;
                break;
        }
        //other
    }
    public void keyReleased(KeyEvent e) {
        //stänger av movement när knapp släpps
        int input = (e.getKeyCode());
        switch (input) {
            case 87:
                playerUp = false;
                break;
            case 83:
                playerDown = false;
                break;
            case 65:
                playerLeft = false;
                break;
            case 68:
                playerRight = false;
                break;
        }
    }
}
