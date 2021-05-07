package com.bingo.dao;

import com.bingo.entity.TMockText;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TMockTextDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TMockText record);

    int insertSelective(TMockText record);

    TMockText selectByPrimaryKey(Integer id);
    
    List<TMockText> getAll();

    int updateByPrimaryKeySelective(TMockText record);

    int updateByPrimaryKey(TMockText record);
}