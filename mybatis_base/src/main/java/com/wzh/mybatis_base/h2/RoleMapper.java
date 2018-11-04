package com.wzh.mybatis_base.h2;

import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select("select * from role where roleid=#{roleid}")
    public Role getRole(int roleid);
}
