package com.example.server2.controller;

import com.example.server2.service.downloadService;
import com.example.server2.utils.JWTHS256;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Controller
@ResponseBody
public class downloadController {
    @Autowired
    private downloadService downloadservice;
    @RequestMapping("/download")
    @CrossOrigin
    public JSONObject download(@RequestParam String token){
        String account = JWTHS256.vaildToken(token);
        byte[] temp = downloadservice.imageToBytes(account);
        String base64Str = Base64.getEncoder().encodeToString(temp);
        JSONObject json =new JSONObject();
        json.put("image",base64Str);
        String name = downloadservice.queryName(account);
        name = name.substring(0,name.length()-4);
        name = name + ".txt";
        String path = "C:\\outputs\\text\\" + name;
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        json.put("text",content);
        return json;
    }

}
