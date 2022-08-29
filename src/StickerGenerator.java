import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    public void create(InputStream inputStream ,String archiveName) throws Exception {
        // Read the image
        // InputStream inputStream = new URL("https://assets.change.org/photos/7/fx/qh/ElFXQhhJTDwsGpL-800x450-noPad.jpg").openStream();
                
        BufferedImage img = ImageIO.read(inputStream);

        // Get the img size and new height
        int width = img.getWidth();
        int height = img.getHeight();
        int newHeight = height + 50;

        // Create a new img how bg transparent
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Get the new img and transform in graphic for manipulation
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(img, 0, 0, null); // Begin write the new imaga, paste the old img in top 0px and left 0px

        // Write a text on the image
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 32); // Config the font
        graphics.setFont(font); // Apply de font

        graphics.setColor(Color.YELLOW); // Apply the font color

        String word = "Hello World";
        graphics.drawString(word, 0, newHeight - 25);

        // Transform the graphics in a new img
        ImageIO.write(newImg, "png", new File("../saida/"+archiveName+".png"));
    }
}
