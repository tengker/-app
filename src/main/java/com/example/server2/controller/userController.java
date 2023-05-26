package com.example.server2.controller;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponseBody;
import com.example.server2.entity.user;
import com.example.server2.service.downloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.server2.service.userService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.server2.utils.JWTHS256;
import com.example.server2.utils.register;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import com.example.server2.utils.validateCaptcha;
@Controller
public class userController {
    @Autowired
    private userService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login (@RequestBody JSONObject temp) throws Exception {
        JSONObject jsonobject = new JSONObject();
        if(Objects.equals(temp.getString("text"), "login")){
            String password = temp.getString("password");
            String account = temp.getString("account");
            user user = userService.queryUser(account);
            String token = "";

            if(user.getPassword().equals(password)){
                token = JWTHS256.buildJWT(account);
                jsonobject.put("code","1");
                jsonobject.put("token",token);
            }
            else{
                jsonobject.put("code","-1");
            }
            return jsonobject;
        } else if (Objects.equals(temp.getString("text"), "sendSms")) {
            String account = temp.getString("account");
            String captcha =  register.sendSms(account);
            jsonobject.put("captcha",captcha);
            return jsonobject;
        } else if (Objects.equals(temp.getString("text"), "show")) {
            String token = temp.getString("token");
            //String account = JWTHS256.vaildToken(token);
            String account="admin";
            if(account!=null){
                user user = userService.queryUser(account);
                String avatar_path = user.getAvatar();
                avatar_path.replace('/','\\');
                String nickname = user.getNickname();
                String base64Str = Base64.getEncoder().encodeToString(userService.imgToBytes(avatar_path));
                jsonobject.put("avatar",base64Str);
                jsonobject.put("nickname",nickname);
            }
            return jsonobject;
        }
        else if(Objects.equals(temp.getString("text"),"register")){
            JSONObject jsonObject =new JSONObject();
            String account = temp.getString("account");
            String password = temp.getString("password");
            String captcha =temp.getString("captcha");
            List<QuerySendDetailsResponseBody.QuerySendDetailsResponseBodySmsSendDetailDTOsSmsSendDetailDTO>result =  validateCaptcha.get();
            String content = result.get(0).content;
            content = content.substring(15,21);
            if(Objects.equals(content,captcha)){
                userService.insertUser(account,password);
                jsonobject.put("code","ok");
            }else {
                jsonobject.put("code","fail");
            }
            return jsonobject;
        }
        return jsonobject;
    }
}
