package com.wzh.mybatis_base.h2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleBo {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public Role getRole(int roleid) {
        SqlSession sqlSession = null;

        try {
            sqlSession = sqlSessionFactory.openSession();
            return sqlSession.getMapper(RoleMapper.class).getRole(roleid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return new Role();
    }

}
