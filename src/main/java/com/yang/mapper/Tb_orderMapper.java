package com.yang.mapper;

import com.yang.bean.Tb_order;
import com.yang.bean.Tb_orderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tb_orderMapper {
    int countByExample(Tb_orderExample example);

    int deleteByExample(Tb_orderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Tb_order record);

    int insertSelective(Tb_order record);

    List<Tb_order> selectByExample(Tb_orderExample example);

    Tb_order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Tb_order record, @Param("example") Tb_orderExample example);

    int updateByExample(@Param("record") Tb_order record, @Param("example") Tb_orderExample example);

    int updateByPrimaryKeySelective(Tb_order record);

    int updateByPrimaryKey(Tb_order record);
}