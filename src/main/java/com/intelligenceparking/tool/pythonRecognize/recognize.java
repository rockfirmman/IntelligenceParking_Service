package com.intelligenceparking.tool.pythonRecognize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class recognize {
    public static String getLicense(String commandPath, String picPath){
        String license = "";
        try {
            String[] commands = new String[] { "python", commandPath, picPath};
            Process proc = Runtime.getRuntime().exec(commands);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"gb2312")); //gb2312防止调用乱码
//            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                license = line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return license;
    }
}
