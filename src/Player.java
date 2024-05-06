public class Player extends livingEntity{
    protected boolean down,up,left,right,dash;
    private float yVel;
    private float maxVel = 4.0F;
    Enemy enemy;

    public Player(float x, float y, int width, int height, char objectDir, World world,Enemy enemy,Panel panel ) {
        super(x, y, width, height,objectDir,world,panel);
        this.enemy = enemy;
    }

    @Override
    public void update() {
        playerMove();
        takeDamage();
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
    public void takeDamage(){
        if (x >= enemy.getX() && x <= enemy.getX()+enemy.getWidth() && y+height >= enemy.getY() && y+height <= enemy.getY()+enemy.getHeight()){
            health -= enemy.getDamage();
        }
    }

    @Override
    public void setStringLocation() {
        location = "/Skeleton.png";
    }

    @Override
    public void setImgSize() {
        imgHeight = 32;
        imgWidth = 22;
    }

    @Override
    public void setImageProperties() {
        setImgSize();
        setStringLocation();
        importImage();
        setAnimationArray();
    }
}
