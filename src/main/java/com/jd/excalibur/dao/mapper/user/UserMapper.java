/*
 * Copyright (c) 2017, www.jd.com. All rights reserved.
 *
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 *
 */

package com.jd.excalibur.dao.mapper.user;

import com.jd.excalibur.dao.sqlprovider.user.UserSqlProvider;
import com.jd.excalibur.vo.PageInf;
import com.jd.excalibur.vo.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    String TABLE_NAME = "user_info";

    @Insert("insert into "+TABLE_NAME+"(pin,password) " +
            "values(#{user.pin},#{user.password})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    Long insert(@Param("user") User user);


    @SelectProvider(type = UserSqlProvider.class,method = "queryForListSql")
    List<User> queryForList(@Param("query") PageInf query);

    @Select("select count(1) from "+TABLE_NAME)
    Integer queryForCount();

    @Select("select * from "+TABLE_NAME+" where pin=#{pin}")
    User getByPin(@Param("pin") String pin);
}

