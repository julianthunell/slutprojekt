public class movingObject {
    //x and y position of the object
    float x;
    float y;

    //size of the object
    float width;
    float height;

    //other chaectheristics
    char objectDir;
    public movingObject(float x, float y, float width, float height, char objectDir){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectDir = objectDir;
    }
}
