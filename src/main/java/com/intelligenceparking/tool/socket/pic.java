package com.intelligenceparking.tool.socket;
import com.intelligenceparking.controller.BillController;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class pic {
    public static void main( final String[] pic ) {
//        for (byte i = 0; i < 127; i++) {
//            BufferedImage img = map( 320, 240, i );
//            savePNG( img, "C:/Users/rockfirmman/Desktop/bmp/test"+i+".bmp" );
//        }
        BufferedImage img = map( 320, 240,255);
        savePNG( img, "C:/Users/rockfirmman/Desktop/test.bmp" );
    }

    private static BufferedImage map( int sizeX, int sizeY,int color){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        int position = 0;
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                res.setRGB(x, y, color);
            }
        }
        return res;
    }

    private static void savePNG( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
