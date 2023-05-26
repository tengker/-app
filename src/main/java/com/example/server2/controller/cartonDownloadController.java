package com.example.server2.controller;
import com.example.server2.service.userService;
import com.alibaba.fastjson.JSONObject;
import com.example.server2.service.cartonService;
import com.example.server2.utils.JWTHS256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;

@Controller
public class cartonDownloadController {
    @Autowired
    private cartonService animalService;
    @Autowired
    private userService userService;
    @RequestMapping("/cartonDownload")
    @ResponseBody
    public JSONObject download(@RequestParam String token){
        String account= JWTHS256.vaildToken(token);
        String result = animalService.queryResult(account);
        String base64Str = Base64.getEncoder().encodeToString(userService.imgToBytes(result));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image",base64Str);
        return jsonObject;
    }
}
