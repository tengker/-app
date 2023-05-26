package com.example.server2.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class useColorPython {
    public void  usePython(String account,String choice,String imgName){
        Runtime r = Runtime.getRuntime();
        String[] args1 = new String[] {"C:\\Users\\liujiateng\\anaconda3\\envs\\sub_pixel\\python.exe","C:\\Users\\liujiateng\\Desktop\\pycode\\changeBaseColor.py",
                String.valueOf(account),String.valueOf(choice),String.valueOf(imgName)};
        Process proc;
        try {
            proc = r.exec(args1);
            proc.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            BufferedReader error = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
            String err = "",line="";
            while ((err = error.readLine()) != null) {
                System.out.println("=====error：" + err);
            }
            while ((line = in.readLine()) != null) {
                System.out.println("=====python返回结果：" + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
