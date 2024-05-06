public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;
    private final int ups = 120;
    World world = new World (350);
    Enemy enemy = new Enemy(0,100,46,27,'R', world,panel);
    Player player = new Player((400)-13,100,44,64,'R', world, enemy,panel);



    //Creating Gamewindow and Gamepanel
    //Sending the objects
    //starting the game
    public Game(){
        startAnimationOjects();
        panel = new Panel(player,enemy,world);
        window = new Window(panel);
        panel.requestFocus();
        startGameloop();

        player.setHealth(5);
        enemy.setDamage(1);
    }

    //Updates all logic
    private void updateGame() {
        player.update();
        enemy.update();
    }

    //this method is used to set up the Animated objects to be ready for starting the game
    private void startAnimationOjects(){
        player.setImageProperties();
        world.setImageProperties();
        enemy.setImageProperties();
    }

    //thread for gameloop
    private void startGameloop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //game loop
    @Override
    public void run() {

        //time variables
        double timePerFrame = 1000000000.0/fps;
        double timePerUpdate = 1000000000.0/ups;
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long now;

        //infinite loop
        while (true){
            now = System.nanoTime();

            //update if time passed since the last frame rendered is equal to the set fps
            if(now - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = now;
            }

            //render if time passed since the last frame rendered is equal to the set fps
            if(now - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
            }
        }
    }

}
