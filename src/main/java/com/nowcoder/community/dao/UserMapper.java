package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(int id); // 根据id查询用户

    User selectByName(String username); //根据用户名查user

    User selectByEmail(String email); //根据邮箱查

    int insertUser(User user); //插入user

    int updateStatus(int id, int status); //更新user状态

    int updateHeader(int id, String headerUrl);  //更新user的头像

    int updatePassword(int id, String password); //更新user的密码
}
