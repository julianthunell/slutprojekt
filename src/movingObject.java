public abstract class movingObject extends AnimatedObject {
    //x and y position of the object
    float x;

    float y;

    //size of the object
    float width;
    float height;

    //other variables
    char objectDir;
    World world;

    Panel panel;
    public movingObject(float x, float y, int width, int height, char objectDir, World world, Panel panel){
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
    public boolean canMove(String direction){
        switch (direction){
            case "left":
                if (x < 0)
                    return false;
                break;
            case "right":
                if (x >= panel.windowWidth-width)
                    return false;
                break;
            case "down":
                if (y >= world.floorLevel-height)
                    return false;
                break;
            case "up":
                if (y < world.floorLevel-height-1) {
                    return false;
                }
                break;
        }
        return true;
    }
    //getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    //setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    //update function for logic
    public abstract void update();

}
