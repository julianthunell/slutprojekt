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
    protected void update() {
        playerMove();
        updateDirection();
        takeDamage();
    }

    //Changes player direction
    private void updateDirection(){
        if(objectDir == 'L'){
            width = -44;
        }
        else if(objectDir == 'R'){
            width = 44;
        }
    }
    //Calculates and changes the position of player
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
    //Calculates if damage has been taken and changes health.
    private void takeDamage(){
        if (x >= enemy.getX() && x <= enemy.getX()+enemy.getWidth() && y+height >= enemy.getY() && y+height <= enemy.getY()+enemy.getHeight()){
            health -= enemy.getDamage();

            resetVariables();
        }
    }
    //resets positions and changes velocity
    private void resetVariables(){
        x = 400;
        y = 100;

        enemy.setX(0);
        if(enemy.getxVel() > 0){
            enemy.setxVel(enemy.getxVel()+1);
        }
        else{
            enemy.setxVel(enemy.getxVel()-1);
            enemy.setxVel(enemy.getxVel()*-1);
        }
    }

    @Override
    protected void setStringLocation() {
        location = "/Skeleton.png";
    }

    @Override
    protected void setImgSize() {
        imgHeight = 32;
        imgWidth = 22;
    }

    @Override
    protected void setImageProperties() {
        setImgSize();
        setStringLocation();
        importImage();
        setAnimationArray();
    }
    // declares panel
    public void setPanel(Panel panel) {
        this.panel= panel;
    }
}
