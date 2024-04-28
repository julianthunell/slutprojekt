import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class AnimatedObject {
    private BufferedImage imageSheet;
    String location;

    //This method is used to import the image used to display the animated object
    private void importImage(){
        InputStream imageStream = getClass().getResourceAsStream(location);
        try{
            imageSheet = ImageIO.read(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This is a method that needs to be called
    //because a location for the imported image must be set
    public abstract void setStringLocation();
}
