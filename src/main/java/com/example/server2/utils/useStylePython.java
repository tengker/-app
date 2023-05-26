package com.example.server2.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class useStylePython {
    public void  usePython(String imgName,String choice,String account){
        Runtime r = Runtime.getRuntime();
        String[] args1 = new String[] {"C:\\Users\\liujiateng\\anaconda3\\envs\\deoldify\\python.exe","C:\\Users\\liujiateng\\Desktop\\pycode\\style_transfer.py",
                String.valueOf(imgName),String.valueOf(choice),String.valueOf(account)};
        Process proc;
        try {
            proc = r.exec(args1);
            proc.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
