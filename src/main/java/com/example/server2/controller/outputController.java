package com.example.server2.controller;

import com.example.server2.service.userOutputService;
import com.example.server2.service.userService;
import com.example.server2.utils.useColorPython;
import com.example.server2.utils.useStylePython;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.server2.utils.JWTHS256;

import java.io.File;
import java.io.IOException;

import java.util.*;

@Controller
public class outputController {
    @Autowired
    private userOutputService outputService;
    @Autowired
    private userService userservice;

    @RequestMapping("/style")
    @ResponseBody
    public void changeStyle(@RequestParam("file") MultipartFile[] files, HttpServletRequest request){
        File dest = new File("C:\\style_transfer\\inputs" + '\\' + files[0].getOriginalFilename());
        try {
            files[0].transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String,String> parmMap=new HashMap<String,String>();
        Map<String,String[]> map= request.getParameterMap();
        //参数名称
        Set<String> key=map.keySet();
        //参数迭代器
        Iterator<String> iterator = key.iterator();
        while(iterator.hasNext()){
            String k=iterator.next();
            parmMap.put(k, map.get(k)[0]);
        }String token = parmMap.get("token");
        String account = JWTHS256.vaildToken(token);
        //System.out.print(account);
        String choice = parmMap.get("choice");
        useStylePython trans = new useStylePython();
        trans.usePython(files[0].getOriginalFilename(),choice,account);
    }
}
