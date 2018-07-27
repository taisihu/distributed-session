package net.groovytest;

import common.BaseJunit4Test;
import net.groovytest.model.RuleClazz;
import net.groovytest.parse.ParseUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/21.
 */
public class TestRuleParseUtil extends BaseJunit4Test{

    private final static Logger logger = LoggerFactory.getLogger(TestRuleParseUtil.class);

    @Resource
    private ParseUtil parseUtil;

    @Test
    public void testParse(){

        logger.error("aaaaaaaaaaaaaaaaa");

//        parseUtil.loadRuleClass();
//
//        RuleClazz ruleClazz = parseUtil.findClazz("rule51job");
//
//        ruleClazz.parse();

    }

}
