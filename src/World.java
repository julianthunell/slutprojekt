public class World extends AnimatedObject{

    //Variables for world
    private int floorLevel;

    public World(int floorLevel){
        this.floorLevel = floorLevel;
    }

    @Override
    protected void setStringLocation() {
        location = "/Background.png";
    }

    @Override
    protected void setImgSize() {
        imgWidth = 576;
        imgHeight = 324;
    }

    @Override
    protected void setImageProperties() {
        setImgSize();
        setStringLocation();
        importImage();
        setAnimationArray();
    }
    //getters setters
    protected int getFloorLevel() {
        return floorLevel;
    }
    protected void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }
}
