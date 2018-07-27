package net.hk.mvcc.service;

import net.hk.mvcc.pojo.DataTest;

import java.util.List;

/**
 * Created by Administrator on 2017/1/17.
 */
public interface DataAccessService {

    List<DataTest> listData();

    DataTest findById(Integer id);

    int updateNumber(DataTest dataTest);

    Exception updNumWithRetry(int id) throws Exception;

}
