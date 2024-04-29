import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class AnimatedObject {
    public BufferedImage imageSheet;
    private String location = "/smiley.png";
    public BufferedImage[][] Animations;

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
    public void setAnimationArray(){
    }

    //This is a method that needs to be called
    //because a location for the imported image must be set
    public abstract void setStringLocation();
}
