package com.example.server2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.server2.utils.useColorPython;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.server2.service.baseColorService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.server2.service.userService;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.example.server2.utils.JWTHS256;
@Controller

public class baseColorController {
    @Autowired
    private baseColorService baseColorService;
    @Autowired
    private userService userService;
    @ResponseBody
    @RequestMapping("/baseColor")
    public void changeBaseColor(@RequestParam("file") MultipartFile[] files, HttpServletRequest request){
        File dest = new File("C:\\baseColor\\input" + '\\' + files[0].getOriginalFilename());
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
        }
        String account=JWTHS256.vaildToken(parmMap.get("token"));
        String choice = parmMap.get("choice");
        String imgName = files[0].getOriginalFilename();
        useColorPython useColorPath = new useColorPython();
        useColorPath.usePython(account,choice,imgName);
    }
}
