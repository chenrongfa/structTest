package com.yy.struct.struct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by crf on 2017/12/15
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function:
 */
@Controller
public class LoginController {
    @GetMapping
    public String login(){
        return "login";
    }
}
