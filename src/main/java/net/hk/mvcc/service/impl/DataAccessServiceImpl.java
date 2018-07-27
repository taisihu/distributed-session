package net.hk.mvcc.service.impl;

import com.google.common.base.Predicate;
import net.hk.mvcc.mapper.DataTestMapper;
import net.hk.mvcc.pojo.DataTest;
import net.hk.mvcc.service.DataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/1/17.
 */
@Service
public class DataAccessServiceImpl implements DataAccessService {

//    private static final AtomicInteger COUNT_CAL = new AtomicInteger(0);

    private static AtomicInteger COUNT_CAL = new AtomicInteger();

    @Autowired
    private DataTestMapper dataTestMapper;

    @Override
    public List<DataTest> listData() {
        return dataTestMapper.listData();
    }

    @Override
    public DataTest findById(Integer id) {
        return dataTestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNumber(DataTest dataTest) {

       int result = dataTestMapper.updateNumber(dataTest);
        if(result==1){
            COUNT_CAL.addAndGet(1);
        }

//        count.addAndGet(1);
//        System.out.println(count.get());
        System.out.println(COUNT_CAL);
        return result;
    }

    @Override
    public Exception updNumWithRetry(final int id) throws Exception{
            // 构建重试模板实例
            RetryTemplate retryTemplate = new RetryTemplate();
            // 设置重试策略，主要设置重试次数
            SimpleRetryPolicy policy = new SimpleRetryPolicy(3, Collections.<Class<? extends Throwable>, Boolean> singletonMap(Exception.class, true));
            // 设置重试回退操作策略，主要设置重试间隔时间
            FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
            fixedBackOffPolicy.setBackOffPeriod(100);
            retryTemplate.setRetryPolicy(policy);
            retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
            // 通过RetryCallback 重试回调实例包装正常逻辑逻辑，第一次执行和重试执行执行的都是这段逻辑
            final RetryCallback<Object, Exception> retryCallback = new RetryCallback<Object, Exception>() {
                //RetryContext 重试操作上下文约定，统一spring-try包装
                public Object doWithRetry(RetryContext context) throws Exception {
                    DataTest dataTest = dataTestMapper.selectByPrimaryKey(id);
                    dataTest.setNumber(dataTest.getNumber()+1);
                    Exception e = dataTestMapper.updNumWithRetry(dataTest);
//                    System.out.println(context.getRetryCount());
                    throw e;//这个点特别注意，重试的根源通过Exception返回
//                    return null;
                }
            };
            // 通过RecoveryCallback 重试流程正常结束或者达到重试上限后的退出恢复操作实例
            final RecoveryCallback<Object> recoveryCallback = new RecoveryCallback<Object>() {
                public Object recover(RetryContext context) throws Exception {
                    System.out.println("do recory operation");
                    return null;
                }
            };
            try {
                // 由retryTemplate 执行execute方法开始逻辑执行
                retryTemplate.execute(retryCallback, recoveryCallback);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

}
