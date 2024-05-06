import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public abstract class AnimatedObject {
    public BufferedImage imageSheet;
    public String location = "/smiley.png";
    public BufferedImage[][] Animations;
    private int arrayHeight,arrayWidth;

    public int imgHeight;
    public int imgWidth;

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
        System.out.println(imageSheet.getWidth());
        System.out.println(imageSheet.getHeight());
        arrayHeight = imageSheet.getHeight()/ imgHeight;
        arrayWidth = imageSheet.getWidth()/ imgWidth;

        if(arrayHeight == 0){
            arrayHeight = 1;
        }
        Animations = new BufferedImage[arrayWidth][arrayHeight];

        for (int i = 0; i < arrayHeight ; i++) {
            for (int j = 0; j < arrayWidth ; j++) {
                Animations[j][i] = imageSheet.getSubimage(j* imgWidth,i* imgHeight, imgWidth, imgHeight);
            }
        }

    }

    //This is a method that needs to be called
    //because a location for the imported image must be set
    public abstract void setStringLocation();

    public abstract void setImgSize();
}