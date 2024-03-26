public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;
    private final int ups = 120;

    public Game(){
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
        startGameloop();
    }

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
                panel.updateGame();
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
