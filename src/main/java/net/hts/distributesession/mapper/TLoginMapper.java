package net.hts.distributesession.mapper;

import net.hts.distributesession.model.TLogin;
import org.springframework.stereotype.Repository;

@Repository
public interface TLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLogin record);

    int insertSelective(TLogin record);

    TLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLogin record);

    int updateByPrimaryKey(TLogin record);

    TLogin findByUserName(String userName);
}