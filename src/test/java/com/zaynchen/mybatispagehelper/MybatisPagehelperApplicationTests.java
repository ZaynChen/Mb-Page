package com.zaynchen.mybatispagehelper;

import com.zaynchen.mybatispagehelper.plugin.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPagehelperApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    @Test
    public void test() {
        SqlSession sqlSession = getSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        RowBounds rowBounds = new RowBounds(0, 1);
        List<SysRole> list = roleMapper.selectAll(rowBounds);
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        System.out.println("\n-------------");
        PageRowBounds pageRowBounds = new PageRowBounds(0, 1);
        list = roleMapper.selectAll(pageRowBounds);
        System.out.println(" 查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        pageRowBounds = new PageRowBounds(1, 1);
        list = roleMapper.selectAll(pageRowBounds);
        System.out.println(" 查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        System.out.println();
        System.out.println("********************************************");

        list = roleMapper.selectById(2L, rowBounds);
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        System.out.println("\n-------------");
        pageRowBounds = new PageRowBounds(0, 1);
        list = roleMapper.selectById(2L, pageRowBounds);
        System.out.println(" 查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        pageRowBounds = new PageRowBounds(1, 1);
        list = roleMapper.selectById(2L, pageRowBounds);
        System.out.println(" 查询总数：" + pageRowBounds.getTotal());
        for (SysRole role : list) {
            System.out.print("角色名：" + role.getRoleName());
        }
        System.out.println();

    }

}
