public class Game implements Runnable {
    private Window window;
    private Panel panel;
    private Thread gameThread;
    private final int fps = 60;
    private final int ups = 120;

    public Game(){

        //gamestart
        panel = new Panel();
        window = new Window(panel);
        panel.requestFocus();
        startGameloop();
    }

    private void startGameloop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0/fps;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        while (true){
            if(now - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
            }
        }
    }
}
