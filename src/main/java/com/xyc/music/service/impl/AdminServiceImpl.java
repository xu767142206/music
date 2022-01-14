package com.xyc.music.service.impl;

import com.xyc.music.entity.Admin;
import com.xyc.music.mapper.AdminMapper;
import com.xyc.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean ValidatePassword(String userName, String passWord) {

        return adminMapper.validatePassword(userName, DigestUtils.md5DigestAsHex(passWord.getBytes())) > 0;

    }


    @Override
    public Admin register(String userName, String passWord) {
        Admin result = null;
        Admin admin = adminMapper.findOne(userName);
        if (admin != null) throw new RuntimeException("已经有admin账户了");
        admin = new Admin();
        admin.setName(userName);
        admin.setPassword(DigestUtils.md5DigestAsHex(passWord.getBytes()));
        Integer id = adminMapper.add(admin);
        if (id > 0) {
            result = admin;
        }
        return result;
    }
}
