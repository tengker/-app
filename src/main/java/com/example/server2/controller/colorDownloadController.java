package com.example.server2.controller;
import com.example.server2.service.baseColorService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.server2.service.userService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.server2.utils.JWTHS256;
import java.util.Base64;

@Controller

public class colorDownloadController {
    @Autowired
    private userService userService;
    @Autowired
    private baseColorService baseColorService;
    @ResponseBody
    @RequestMapping("/color")
    public JSONObject download(@RequestParam String token){
        String account=JWTHS256.vaildToken(token);
        String path = baseColorService.queryPath(account);
        path = path.replace('/','\\');
        String base64Str = Base64.getEncoder().encodeToString(userService.imgToBytes(path));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image",base64Str);
        return jsonObject;
    }
}
