package com.dalingjia.file;

import java.io.File;
import java.io.IOException;

public class MakeFiles {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            makeDir();
        }
    }

    private static void makeDir() {
        //创建目录
        File dir = new File("/tmp/contractTmpDir");
        if(!dir.exists()){
            dir.mkdir();
        }
        System.out.println(dir.getAbsoluteFile());
        //指定目录下创建文件
        File file = new File(dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".pdf");
        try {
            file.createNewFile();
            System.out.println(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }


    }
}
