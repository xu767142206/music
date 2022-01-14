package com.xyc.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.xyc.music.service.AdminService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class BackgroundLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object Login(HttpServletRequest request, HttpSession session) {
        JSONObject object = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (adminService.ValidatePassword(username, password)) {
            object.put("code", 200);
            object.put("msg", "登录成功!");
            object.put("data", null);
            return object;
        }
        object.put("code", 400);
        object.put("msg", "登录失败!");
        object.put("data", null);
        return object;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(HttpServletRequest request, HttpSession session) {
        JSONObject object = new JSONObject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (adminService.register(username, password) != null) {
            object.put("code", 200);
            object.put("msg", "注册成功!");
            object.put("data", null);
            return object;
        }
        object.put("code", 400);
        object.put("msg", "注册失败!");
        object.put("data", null);
        return object;
    }
}
