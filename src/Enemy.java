public class Enemy extends livingEntity{

    private float yVel;
    private float xVel = 1;
    private float maxVel = 4.0F;

    public Enemy(float x, float y, int width, int height, char objectDir, World world,Panel panel) {
        super(x, y, width, height,objectDir,world,panel);
    }
    private void enemyMove(){
        y += yVel;
        x += xVel;
        //Gravity
        if(yVel < maxVel){
            yVel += 0.04F;
        }
        //stopping player when touching ground
        if (!canMove("down")){
            yVel = 0;
        }

        if (x <= 0 || x >= 700){
            xVel *=-1;
        }

    }

    public float getxVel() {
        return xVel;
    }

    public void setxVel(float xVel) {
        this.xVel = xVel;
    }

    @Override
    public void update() {
        enemyMove();
    }

    @Override
    public void setStringLocation() {
        location = "Dead.png";
    }

    @Override
    public void setImgSize() {
        imgWidth = 46;
        imgHeight  = 27;
    }

    @Override
    public void setImageProperties() {
        setImgSize();
        setStringLocation();
        importImage();
        setAnimationArray();
    }
}
