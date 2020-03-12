package com.huan.dao;

import com.huan.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface ItemMappper {
    List<Item> queryItemList();
}
