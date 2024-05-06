public class Player extends livingEntity{
    protected boolean down,up,left,right,dash;
    private float yVel;
    private float maxVel = 4.0F;

    public Player(float x, float y, int width, int height, char objectDir, World world ) {
        super(x, y, width, height,objectDir,world);
    }

    @Override
    public void update() {
        playerMove();
    }

    private void playerMove(){
        y += yVel;
        //Gravity
        if(yVel < maxVel){
            yVel += 0.04F;
        }
        //stopping player when touching ground
        if (!canMove("down")){
            yVel = 0;
        }
        //left right movement
        if(left && canMove("left")){
            x -= 2F;
        }
        if(right && canMove("right")){
            x += 2F;
        }
        //Jump
        if(up && canMove("up")){
            yVel = - 3;
        }
    }

    @Override
    public void setStringLocation() {
        location = "/test.png";
    }

    @Override
    public void setImgSize() {
        imgHeight = 50;
        imgWidth = 50;
    }
}
