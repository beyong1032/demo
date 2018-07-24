package com.ep98.employee.dao;

import com.ep98.employee.domain.Ka;

public interface KaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ka record);

    int insertSelective(Ka record);

    Ka selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ka record);

    int updateByPrimaryKey(Ka record);
}