import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class AnimatedObject {
    protected BufferedImage imageSheet;
    protected String location = "/smiley.png";
    protected BufferedImage[][] animations;
    private int arrayHeight,arrayWidth;
    protected int imgHeight;
    protected int imgWidth;

    //This method is used to import the image used to display the animated object
    protected void importImage(){
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
    protected void setAnimationArray(){
        arrayHeight = imageSheet.getHeight()/ imgHeight;
        arrayWidth = imageSheet.getWidth()/ imgWidth;


        animations = new BufferedImage[arrayWidth][arrayHeight];

        for (int i = 0; i < arrayHeight ; i++) {
            for (int j = 0; j < arrayWidth ; j++) {
                animations[j][i] = imageSheet.getSubimage(j* imgWidth,i* imgHeight, imgWidth, imgHeight);
            }
        }
    }

    //The following methods needs to be called

    //location for the imported image must be set
    protected abstract void setStringLocation();

    //Image width and size
    protected abstract void setImgSize();

    //Initiates the properties for the animations
    protected abstract void setImageProperties();
}