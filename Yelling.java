import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Yelling {

    private void convertToAscii(String imgName) {
        BufferedImage img;
        try {
            img = ImageIO.read(new File(imgName));
        } catch (IOException e) {
            return;
        }

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color pixCol = new Color(img.getRGB(j, i));
                double pixVal = (((pixCol.getRed() * 0.30) + (pixCol.getBlue() * 0.59) + (pixCol
                        .getGreen() * 0.11)));
                String nextLine = strChar(pixVal);
                System.out.print(nextLine);
            }
            System.out.print("\n");
        }
    }

    private String strChar(double g) {
        String str;
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }

    public static void main(String[] args) {
        Yelling obj = new Yelling();
        obj.convertToAscii(args[0]);
    }
}