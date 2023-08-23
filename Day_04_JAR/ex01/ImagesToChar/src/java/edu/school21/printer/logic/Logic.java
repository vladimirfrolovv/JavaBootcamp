package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {
    public static int[][] convertImage(char white, char black) throws Exception {
            BufferedImage image = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));
        int[][] array_pixels = new int[image.getWidth()][image.getHeight()];

        for (int i = 0; i < image.getWidth(); ++i) {
            for (int j = 0; j < image.getHeight(); ++j) {
                int color = image.getRGB(i,j);
                if (color == Color.BLACK.getRGB()) {
                    array_pixels[i][j] = black;
                } else if (color == Color.WHITE.getRGB()) {
                    array_pixels[i][j] = white;
                }
            }
        }
        return array_pixels;
    }
}
