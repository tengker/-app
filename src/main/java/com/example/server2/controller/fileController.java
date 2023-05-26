package com.example.server2.controller;

import com.example.server2.utils.JWTHS256;
import com.example.server2.utils.usePython;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@ResponseBody
public class fileController {
    @RequestMapping("/deal")
    @CrossOrigin
    public void dealImg(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        File dest = new File("C:/inputs" + '/' + files[0].getOriginalFilename());
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
        usePython temp = new usePython();
        temp.usePython(files[0].getOriginalFilename(),account);
        //System.out.print(files[0].getOriginalFilename());
    }
}
