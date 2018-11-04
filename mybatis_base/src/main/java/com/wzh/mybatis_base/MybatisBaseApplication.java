package com.wzh.mybatis_base;

import com.wzh.mybatis_base.h2.*;
import com.wzh.mybatis_base.mybatis.MybatisSerivce;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MybatisBaseApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MybatisBaseApplication.class, args);
		MybatisSerivce mybatisSerivce = context.getBean(MybatisSerivce.class);
//传统写法
		 SqlSession sqlSession = null;
		try {
			sqlSession= mybatisSerivce.getSqlSessionFactory().openSession();
			Blog blog=sqlSession.selectOne("NameSpace.BlogMapper.selectBlog",4);
			System.out.println(blog.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
//改良写法
		sqlSession=mybatisSerivce.getSqlSessionFactory().openSession();
		Role role = sqlSession.getMapper(RoleMapper.class).getRole(3) ;
		System.out.println(role.getRolename());
// 自己融入spring  boot

		RoleBo roleBo = context.getBean(RoleBo.class);
		System.out.println(roleBo.getRole(3).getRolename());


		//sqlSession.getMapper(Blog.class).




	}
}
