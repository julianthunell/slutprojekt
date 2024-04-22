public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;
    private final int ups = 120;
    Player player = new Player(100,100,26,50);
    Enemy enemy = new Enemy(200,100,50,100);

    //Creating Gamewindow and Gamepanel
    //Sending the objects
    //starting the game
    public Game(){
        panel = new Panel(player,enemy);
        window = new Window(panel);
        panel.requestFocus();
        startGameloop();
    }
    //Updates all logic
    private void updateGame() {
        player.update();
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
        long now = System.nanoTime();

        //infinite loop
        while (true){
            now = System.nanoTime();

            //update
            if(now - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = now;
            }

            //render
            if(now - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
            }
        }
    }

}
