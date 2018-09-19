package com.zaynchen.mybatispagehelper.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

public interface Dialect {

    boolean skip(String msId, Object parameterObject, RowBounds rowBounds);

    boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds);

    String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey);

    void afterCount(long count, Object parameterObject, RowBounds rowBounds);

    boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds);

    String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey pageKey);

    Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds);

    void setProperties(Properties properties);
}
