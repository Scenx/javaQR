package com.scen.util;

import java.util.Scanner;

/**
 * 从键盘获取想要
 * Created by scen on 2017/4/24.
 */
public class ScannerUtils {
    public static String sc() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n");
            System.out.println("请输入你希望生成的二维码所扫描的结果并且以回车键结束");
            String data = "";
            s = new Scanner(System.in);
            while (true) {
                data = s.nextLine();
                if ("".equals(data)) {
                    System.out.println("内容不能为空，请重新输入：");
                } else {
                    break;
                }
            }

            return data;

        }
    }
}
