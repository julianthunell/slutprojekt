import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {
    public static int windowWidth = 800;
    private long lastCheck = 0;
    private int frames = 0;
    private int windowHeight = (windowWidth/16) * 9;
    private int AnimationIndex = 0;
    private int currentIndex = 0;
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
        AnimationUpdate();
        fps();
        //background
        g.drawImage(world.Animations[AnimationIndex][0],0,0,windowWidth,windowHeight,null);

        //draws player
        g.drawImage(player.Animations[0][0],(int)player.x,(int)player.y,44,64,null);

        //draw enemy
        g.drawImage(enemy.Animations[0][0],(int)enemy.x,(int)enemy.y,null);
        //draws floor
        Color myColor = Color.decode("#02151C");
        g.setColor(myColor);
        g.fillRect(0, world.floorLevel, windowWidth,200);

        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,28));
        g.drawString(String.valueOf(player.getHealth()),windowWidth/2,100);

    }

    //Fps counter
    public void fps(){

        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("Fps: "+frames);
            frames = 0;
        }
    }

    //AnimationTicker
    public int AnimationUpdate(){
        currentIndex++;
        if(currentIndex >= 5){
            currentIndex = 0;
            AnimationIndex++;
        }
        if(AnimationIndex == 31){
            AnimationIndex = 0;
        }
        return AnimationIndex;
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
