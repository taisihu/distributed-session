package net.hk.mvcc.mapper;

import net.hk.mvcc.pojo.DataTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataTest record);

    int insertSelective(DataTest record);

    DataTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataTest record);

    int updateByPrimaryKey(DataTest record);

    List<DataTest> listData();

    int updateNumber(DataTest dataTest);

    Exception updNumWithRetry(DataTest dataTest);
}