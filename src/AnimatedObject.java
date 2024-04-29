import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class AnimatedObject {
    public BufferedImage imageSheet;
    private String location = "/smiley.png";
    public BufferedImage[][] Animations;
    private int arrayHeight,arrayWidth;

    //This method is used to import the image used to display the animated object
    public void importImage(){
        InputStream imageStream = getClass().getResourceAsStream(location);

        try{
            imageSheet = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                imageStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //This method sets up the array including every part of the image.
    //It creates the array depending on the size of the image and then divides the image in to subimages
    public void setAnimationArray(){
        arrayHeight = imageSheet.getHeight()/50;
        arrayWidth = imageSheet.getWidth()/50;

        Animations = new BufferedImage[arrayWidth][arrayHeight];

        for (int i = 0; i < arrayHeight ; i++) {
            for (int j = 0; j < arrayWidth ; j++) {
                Animations[j][i] = imageSheet.getSubimage(i*50,i*50,50,50);
            }
        }

    }

    //This is a method that needs to be called
    //because a location for the imported image must be set
    public abstract void setStringLocation();
}