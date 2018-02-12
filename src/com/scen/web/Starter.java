package com.scen.web;

import com.scen.util.Generate;
import com.scen.util.ScannerUtils;

/**
 * Created by scen on 2017/4/25.
 */
public class Starter {
    public static void main(String[] args) {
        String data = ScannerUtils.sc();
/**
 * 生成二维码
 */
        Generate.encode(data, "D:/Data/scen.JPG");

    }
}

