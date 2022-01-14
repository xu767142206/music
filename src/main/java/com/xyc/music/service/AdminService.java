package com.xyc.music.service;

import com.xyc.music.entity.Admin;

public interface AdminService {

    public Boolean ValidatePassword(String userName, String passWord);

    public Admin register(String userName, String passWord);
}
