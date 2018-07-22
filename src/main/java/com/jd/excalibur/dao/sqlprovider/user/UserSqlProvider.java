package com.jd.excalibur.dao.sqlprovider.user;

import com.jd.excalibur.dao.mapper.user.UserMapper;
import com.jd.excalibur.dao.sqlprovider.BaseSqlProvider;
import com.jd.excalibur.vo.PageInf;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UserSqlProvider extends BaseSqlProvider {

    private static final String TABLE_NAME = UserMapper.TABLE_NAME;

    public String queryForListSql(Map<String, Object> map){
        PageInf query = (PageInf) map.get("query");
        StringBuilder builder = new StringBuilder();
        builder.append("select * from "+TABLE_NAME);
        //-------------------------------------------------------------------------------
        String querySql = builder.toString();
        log.info("query sql : {}",querySql);
        return limit(querySql,query.getIndex(),query.getSize());
    }
}
