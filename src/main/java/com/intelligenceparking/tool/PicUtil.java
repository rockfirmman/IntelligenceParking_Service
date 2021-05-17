package com.intelligenceparking.tool;

import com.intelligenceparking.bean.BillModel;
import com.intelligenceparking.bean.CarModel;
import com.intelligenceparking.bean.ParkingSlotModel;
import com.intelligenceparking.bean.UserModel;
import com.intelligenceparking.controller.BillController;
import com.intelligenceparking.controller.FileController;
import com.intelligenceparking.service.*;
import com.intelligenceparking.service.serviceImpl.BillServiceImpl;
import com.intelligenceparking.service.serviceImpl.CarServiceImpl;
import com.intelligenceparking.service.serviceImpl.ParkingSlotServiceImpl;
import com.intelligenceparking.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PicUtil {
    public void test(){
        BillService billService = SpringUtil.getBean(BillServiceImpl.class);
        BillModel billModel = billService.selectBillById(2);
        System.out.println(billModel);
    }
    public static String byte2image( final byte[] pic ) {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        String fileName = format.format(date);
        fileName = fileName.replace(":", "");
        fileName = fileName.replace(" ", "") + ".bmp";

        System.out.println("start making pic");
        BufferedImage img = map( 240, 320 ,pic);
        savePNG(img, "/root/" + fileName );
        System.out.println("end making pic");
        return fileName;
    }

    private static BufferedImage map( int sizeX, int sizeY ,byte[] pic){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        int position = 0;
        for (int x = 0; x < 240; x++){
            for (int y = 0; y < 320; y++){
                Color c = RGB565ToRGB24(pic[position] & 0xFF, pic[position+1] & 0xFF);
//                Color c = RGB565ToRGB24(pic[position], pic[position+1]);
                position += 2; //一次两个byte
                res.setRGB(x, y, c.getRGB());
//                System.out.println(c.getBlue()+" "+c.getRed()+" "+c.getGreen());
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

    static Color RGB565ToRGB24(int RGB565_H, int RGB565_L)
    {
        int RGB565_MASK_RED = 0xF800;
        int RGB565_MASK_GREEN = 0x07E0;
        int RGB565_MASK_BLUE = 0x001F;
        int RGB565;
        int R, G, B;
        RGB565_H <<= 8;
        RGB565 = RGB565_H | RGB565_L;
        R = (RGB565 & RGB565_MASK_RED) >> 11;
        G = (RGB565 & RGB565_MASK_GREEN) >> 5;
        B = (RGB565 & RGB565_MASK_BLUE);
        R <<= 3;
        G <<= 2;
        B <<= 3;
        return new Color(R,G,B);
    }
}
