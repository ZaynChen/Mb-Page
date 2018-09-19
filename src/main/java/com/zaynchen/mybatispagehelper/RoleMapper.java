package com.zaynchen.mybatispagehelper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RoleMapper {


    @Results(id = "roleResultMap", value = {
            @Result(column = "ID", property = "roleId", id = true),
            @Result(column = "ROLE_NAME", property = "roleName"),
            @Result(column = "CREATE_BY", property = "createBy"),
            @Result(column = "CREATE_TIME", property = "createTime"),
    })
    @Select("SELECT * FROM SYS_ROLE")
    List<SysRole> selectAll(RowBounds rowBounds);

    @ResultMap("roleResultMap")
    @Select("SELECT * FROM SYS_ROLE WHERE ID = #{id}")
    List<SysRole> selectById(Long id, RowBounds rowBounds);
}
