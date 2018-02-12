package com.scen.util;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by scen on 2017/4/25.
 */
public class Generate {
    private Generate(){}
    public static boolean encode(String srcValue, String qrcodePicfilePath){
        int MAX_DATA_LENGTH = 200;
        byte[] d = srcValue.getBytes();
        int dataLength = d.length;
        int imageWidth = 113;
        int imageHeight = imageWidth;
        BufferedImage bi = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, imageWidth, imageHeight);
        g.setColor(Color.BLACK);
        if (dataLength > 0 && dataLength <= MAX_DATA_LENGTH) {
            Qrcode qrcode = new Qrcode();
            qrcode.setQrcodeErrorCorrect('M');
            qrcode.setQrcodeEncodeMode('B');
            qrcode.setQrcodeVersion(5);
            boolean[][] b = qrcode.calQrcode(d);
            int qrcodeDataLen = b.length;
            for (int i = 0; i < qrcodeDataLen; i++) {
                for (int j = 0; j < qrcodeDataLen; j++) {
                    if (b[j][i]) {
                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
                    }
                }
            }
            System.out.println("二维码成功生成！！");
        } else {
            System.out.println( dataLength +"大于"+ MAX_DATA_LENGTH);
            return false;
        }
        g.dispose();
        bi.flush();
        File f = new File(qrcodePicfilePath);
        String suffix = f.getName().substring(f.getName().indexOf(".")+1, f.getName().length());
        System.out.println("二维码输出成功！！");
        try {
            ImageIO.write(bi, suffix, f);
        } catch (IOException ioe) {
            System.out.println("二维码生成失败" + ioe.getMessage());
            return false;
        }
        return true;
    }
    }

