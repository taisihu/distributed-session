package culeusermatch;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * TODO 需要重写hashCode()和equals()方法
 *
 * Created by Administrator on 2017/2/27.
 */
public class IDPair {

    private Integer id;

    private Integer value;

    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
