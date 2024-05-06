public class World extends AnimatedObject{

    //Variables for world
    int floorLevel;

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
}
