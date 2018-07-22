package com.jd.excalibur.service.user;

import com.jd.excalibur.dao.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Integer getUserCount(){
        return userMapper.queryForCount();
    }

}
