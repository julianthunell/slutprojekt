public class Player extends movingObject{
    protected boolean down,up,left,right;
    private float speed = 2;
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void update(){
        playerMove();
    }
    private void playerMove(){
        //Gravity and jumping


        //left right movement
        if(left && !right && canMove("left")){
            x -= speed;
        }
        if(right && !left  && canMove("right")){
            x += speed;
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
                if (y >= Panel.windowHeight-height)
                    return false;
                break;
            case "up":
                if (y >= 0)
                    return false;
                break;
        }
        return true;
    }
}
