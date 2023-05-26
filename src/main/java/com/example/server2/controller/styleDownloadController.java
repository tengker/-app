package com.example.server2.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.server2.entity.userOutput;
import com.example.server2.service.userOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.server2.service.userService;
import com.example.server2.utils.JWTHS256;
import java.util.Base64;

@Controller
public class styleDownloadController {
    @Autowired
    private userOutputService outputService;
    @Autowired
    private userService userService;
    @RequestMapping("/styledownload")
    @ResponseBody
    public JSONObject download(@RequestParam String token){
        String account=JWTHS256.vaildToken(token);
        userOutput output = outputService.queryPath(account);
        String path = output.getPath();
        path = path.replace('/','\\');
        String base64Str = Base64.getEncoder().encodeToString(userService.imgToBytes(path));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image",base64Str);
        return jsonObject;
    }
}
