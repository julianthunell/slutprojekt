public class World extends AnimatedObject{

    //Variables for world
    private int floorLevel;

    public World(int floorLevel){
        this.floorLevel = floorLevel;
    }

    @Override
    public void setStringLocation() {
        location = "/Background.png";
    }

    @Override
    public void setImgSize() {
        imgWidth = 576;
        imgHeight = 324;
    }

    @Override
    public void setImageProperties() {
        setImgSize();
        setStringLocation();
        importImage();
        setAnimationArray();
    }
    //getters setters
    public int getFloorLevel() {
        return floorLevel;
    }
    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }
}
