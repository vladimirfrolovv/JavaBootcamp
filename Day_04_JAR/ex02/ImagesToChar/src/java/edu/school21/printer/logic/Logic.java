package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import com.diogonunes.jcolor.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Logic {
    private final Attribute white;
    private final Attribute black;
    public Logic(JArgs args) {
        this.white = args.getWhite();
        this.black = args.getBlack();
    }
    public void convertImage() {
        try {
            BufferedImage image = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));
            for (int i = 0; i < image.getWidth(); ++i) {
                for (int j = 0; j < image.getHeight(); ++j) {
                    int color = image.getRGB(j,i);
                    if (color == Color.BLACK.getRGB()) {
                        System.out.print(colorize(" ", black));
                    } else if (color == Color.WHITE.getRGB()) {
                        System.out.print(colorize(" ", white));
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Invalid IO");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Image");
        }

    }
}
