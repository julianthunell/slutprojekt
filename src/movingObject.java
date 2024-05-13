public abstract class movingObject extends AnimatedObject {
    //x and y position of the object
    protected float x;

    protected float y;

    //size of the object
    protected float width;
    protected float height;

    //other variables
    protected char objectDir;
    World world;

    Panel panel;
    protected movingObject(float x, float y, int width, int height, char objectDir, World world, Panel panel){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectDir = objectDir;
        this.world = world;
        this.panel = panel;

    }

    //checks if object can move to chosen direction
    //Works by checking the current position of the object and seeing if it's outside the screen
    protected boolean canMove(String direction){
        switch (direction){
            case "left":
                if (x < 0)
                    return false;
                break;
            case "right":
                if (x >= panel.getWindowWidth()-width)
                    return false;
                break;
            case "down":
                if (y >= world.getFloorLevel()-height)
                    return false;
                break;
            case "up":
                if (y < world.getFloorLevel()-height-1) {
                    return false;
                }
                break;
        }
        return true;
    }
    //getters
    protected float getX() {
        return x;
    }

    protected float getY() {
        return y;
    }

    protected float getWidth() {
        return width;
    }

    protected float getHeight() {
        return height;
    }

    //setters
    protected void setX(float x) {
        this.x = x;
    }

    protected void setY(float y) {
        this.y = y;
    }
    //update function for logic
    protected abstract void update();

}
