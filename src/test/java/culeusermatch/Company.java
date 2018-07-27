package culeusermatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */
public class Company {

    private Integer id;

    private String companyName;

    //储存团队-线索ID
    private Map<Integer,Integer> use_team = new HashMap<Integer,Integer>();

    //存储使用次数
    private Map<Integer,Integer> clue_count = new HashMap<Integer,Integer>();

    public Map<Integer, Integer> getUse_team() {
        return use_team;
    }

    public void setUse_team(Integer culeId,Integer teamId) {
        use_team.put(culeId,teamId);
    }

    public Map<Integer, Integer> getClue_count() {
        return clue_count;
    }

    public void setClue_count(Integer culeId) {
        if(null == clue_count.get(culeId)){
            clue_count.put(culeId,1);
        }else{
            clue_count.put(culeId,clue_count.get(culeId)+1);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
