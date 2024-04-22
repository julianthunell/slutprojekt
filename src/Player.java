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
            xVel -= 0.04F;
        }
        if(right){
            xVel += 0.04F;
        }
        //Jump
        if(up){
            yVel = - 2;
        }
        //dash
        if(dash && objectDir=='R' )
            xVel += 0.2F;
        else if (dash && objectDir=='L') {
            xVel -= 0.2F;
        }

        y += yVel;
        x += xVel;



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
        }
        return true;
    }
}
