package com.xyc.music.mapper;

import com.xyc.music.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    public Integer validatePassword(String userName, String passWord);

    public Integer add(Admin admin);

    public Admin findOne(String userName);
}
