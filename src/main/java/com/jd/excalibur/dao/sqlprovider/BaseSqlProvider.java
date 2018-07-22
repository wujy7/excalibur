package com.jd.excalibur.dao.sqlprovider;

import com.jd.excalibur.common.NumberUtils;

public class BaseSqlProvider {

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    protected String orderBy(String queryForListSql,String column,String orderByType){
        StringBuilder sql = new StringBuilder(queryForListSql);
        sql.append(" order by ").append(column).append(" ").append(orderByType);
        return sql.toString();
    }

    /***
     * 在查询语句上增加分页信息
     * @param selectSql
     * @param page 当前查询的页数
     * @param pageSize 分页大小，如果pageSize <= 0,则使用指定的默认分页值
     * @return
     */
    protected String limit(String selectSql,Integer page,Integer pageSize){
        StringBuilder limitSql = new StringBuilder();
        limitSql.append(selectSql);
        limitSql.append(" limit ").append(getPageStartIndex(page,pageSize));
        limitSql.append(",").append(NumberUtils.isNullOrZero(pageSize) || pageSize < 0 ? DEFAULT_PAGE_SIZE : pageSize);
        return limitSql.toString();
    }


    protected int getPageStartIndex(Integer page,Integer pageSize) {
        return NumberUtils.isNullOrZero(page) || page < 0 ? 0 : (page - 1) * pageSize;
    }
}
