package com.dengji85.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dengji85.demo.domain.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM `user` u WHERE u.`name` = #{name}")
	User findByName(@Param("name") String name);
}
