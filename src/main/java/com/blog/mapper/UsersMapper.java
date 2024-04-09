package com.blog.mapper;

import com.blog.domain.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ZH280
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-04-08 15:02:56
* @Entity com.blog.domain.Users
*/
@Mapper
public interface UsersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    User findByUsername(String username);
}
