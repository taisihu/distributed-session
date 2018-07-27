package net.groovytest.parse;

import common.FileUtil;
import net.groovytest.model.RuleClazz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ParseUtil {

    @Autowired
    private RuleClassLoader ruleClassLoader;

    private Map<String,RuleClazz> clazzMap = new HashMap<String,RuleClazz>();


    public void loadRuleClass(){

        String class_str = FileUtil.readFileContent("E:\\idea_workspace\\activymq\\src\\main\\java\\net\\groovytest\\model\\Rule51Job.java");

        RuleClazz clazz = null;
        Class<RuleClazz> ruleClazz = ruleClassLoader.parseClass(class_str,"rule51job.groovy");
        try {
            clazz = ruleClazz.newInstance();
            if(null != clazz){
                clazzMap.put("rule51job",clazz);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public RuleClazz findClazz(String clazzName){

        return clazzMap.get(clazzName);

    }

}
