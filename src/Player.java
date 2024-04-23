public class Player extends movingObject{
    protected boolean down,up,left,right,dash;
    private float yVel,xVel;
    private float maxVel = 4.0F;
    final int groundLevel = 300;

    public Player(float x, float y, int width, int height, char objectDir) {
        super(x, y, width, height,objectDir);
    }

    public void update(){
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
        if(left){
            x -= 2F;
        }
        if(right){
            x += 2F;
        }
        //Jump
        if(up && canMove("up")){
            yVel = - 3;
            if (right){
                x+=2;
            }
            if (left){
                x-=2;
            }
        }
    }
    //checks if player can move to chosen direction
    private boolean canMove(String direction){
        switch (direction){
            case "left":
                if (x <= 0)
                    return false;
                break;
            case "right":
                if (x >= Panel.windowWidth-width)
                    return false;
                break;
            case "down":
                if (y >= groundLevel+height)
                    return false;
                break;
            case "up":
                System.out.println("tset");
                if (y < groundLevel+height-1) {
                    System.out.println(y);
                    return false;
                }
                break;
        }
        return true;
    }
}
