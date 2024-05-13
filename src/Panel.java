import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {

    private int windowWidth = 800;
    private long lastCheck = 0;
    private int windowHeight = (windowWidth/16) * 9;

    private int score = 0;
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
        this.player.setPanel(this);
    }
    //Paint component - method that paints all objects
    //Updates animation index
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        AnimationUpdate();
        //background
        g.drawImage(world.animations[AnimationIndex][0],0,0,windowWidth,windowHeight,null);

        //draws player
        g.drawImage(player.animations[0][0],(int)player.x,(int)player.y,(int)player.getWidth(),64,null);

        //draw enemy
        g.drawImage(enemy.animations[0][0],(int)enemy.x,(int)enemy.y,null);
        //draws floor
        Color myColor = Color.decode("#02151C");
        g.setColor(myColor);
        g.fillRect(0, world.getFloorLevel(), windowWidth,200);

        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,28));
        g.drawString(String.valueOf(player.getHealth()),windowWidth/2,100);
        g.drawString(String.valueOf(score),30,60);

    }

    //ends game when health is 0
    //Reset all values
    private void endGame(){
        if(player.getHealth() <= 0){
            score = 0;

            player.setHealth(5);

            enemy.setX(0);
            enemy.setxVel(1);

            player.setX(400);
            player.setY(100);
        }
    }

    //AnimationTicker
    private int AnimationUpdate(){
        endGame();
        score++;
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

    //Controls key presses
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

    //getter setters
    protected int getWindowWidth() {
        return windowWidth;
    }
}
