package com.wzh.mybatis_base.h2;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {

    @Select("select * from BLOG WHERE ID=#{id}#")
    public Blog selectID( long id);
}
