import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {
    static int windowWidth = 800;
    private long lastCheck = 0;
    private int frames = 0;
    static int windowHeight = (windowWidth/16) * 9;
    Player player;
    Enemy enemy;

    World world;
    public Panel(Player player, Enemy enemy, World world){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.addKeyListener(this);
        this.player = player;
        this.enemy = enemy;
        this.world = world;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        fps();

        //draws player
        g.fillRect((int)player.x,(int)player.y,(int)player.width,(int)player.height);

        //draws world
        g.fillRect(0, world.floorLevel, windowWidth,10);

    }
    public void fps(){

        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("Fps: "+frames);
            frames = 0;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int input = (e.getKeyCode());
        //starts movement depending on direction
        switch (input){
            case 87:
                player.up = true;
                break;
            case 83:
                player.down = true;
                break;
            case 65:
                player.left = true;
                player.objectDir = 'L';
                break;
            case 68:
                player.right = true;
                player.objectDir = 'R';
                break;
            case 32:
                player.dash = true;
                break;
        }
    }

    //stops movement depending on direction
    public void keyReleased(KeyEvent e) {
        int input = (e.getKeyCode());
        switch (input) {
            case 87:
                player.up = false;
                break;
            case 83:
                player.down = false;
                break;
            case 65:
                player.left = false;
                break;
            case 68:
                player.right = false;
                break;
            case 32:
                player.dash = false;
                break;
        }
    }
}
