package com.blog.mapper;

import com.blog.domain.Operations;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ZH280
* @description 针对表【operations】的数据库操作Mapper
* @createDate 2024-04-08 13:23:45
* @Entity com.blog.domain.Operations
*/
@Mapper
public interface OperationsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Operations record);

    int insertSelective(Operations record);

    Operations selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operations record);

    int updateByPrimaryKey(Operations record);

}
